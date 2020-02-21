package pt.digitalis.poc;

import java.util.Properties;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Consumer {

    private static final String CARBON_CLIENT_ID = "carbon";

    private static final String CARBON_DEFAULT_HOSTNAME = "localhost";
    private static final String CARBON_DEFAULT_PORT = "5676"; // offset = 4
    private static final String CARBON_VIRTUAL_HOST_NAME = "carbon";
    private static final String CF_NAME = "qpidConnectionfactory";
    private static final String CF_NAME_PREFIX = "connectionfactory.";
    private static final Logger LOG = Logger.getLogger(Consumer.class.getName());
    private static final String PASSWORD = "admin";
    private static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    private static final String QUEUE_NAME = "digitalis-queue";
    private static final String USER_NAME = "admin";

    public static void main(String[] args) throws NamingException, JMSException
    {
        Consumer queueReceiver = new Consumer();
        queueReceiver.receiveMessages();
    }

    private QueueConnectionFactory connFactory;
    private InitialContext context;
    private Properties properties;
    private QueueConnection queueConnection;

    private QueueSession queueSession;

    public String getTCPConnectionURL()
    {
        return new StringBuffer().append("amqp://").append(USER_NAME).append(":").append(PASSWORD).append("@")
                .append(CARBON_CLIENT_ID).append("/").append(CARBON_VIRTUAL_HOST_NAME).append("?brokerlist='tcp://")
                .append(CARBON_DEFAULT_HOSTNAME).append(":").append(CARBON_DEFAULT_PORT).append("'").toString();
    }

    private void receiveMessages() throws NamingException, JMSException
    {
        properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
        properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL());
        properties.put("queue." + QUEUE_NAME, QUEUE_NAME);
        LOG.info("getTCPConnectionURL(userName,password) = " + getTCPConnectionURL());
        context = new InitialContext(properties);

        connFactory = (QueueConnectionFactory) context.lookup(CF_NAME);
        queueConnection = connFactory.createQueueConnection();
        queueConnection.start();
        queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

        Queue queue = (Queue) context.lookup(QUEUE_NAME);
        TextMessage message = null;
        MessageConsumer queueReceiver = queueSession.createConsumer(queue);

        while (queueSession.createBrowser(queue).getEnumeration().hasMoreElements())
        {
            message = (TextMessage) queueReceiver.receive();
            LOG.info("Got message ==>  " + message.getText());
        }
        LOG.info("No more message in queue: " + QUEUE_NAME);
        queueReceiver.close();
        queueSession.close();
        queueConnection.stop();
        queueConnection.close();
    }

}
