package com.lopes.wso2.jms.queue;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.lopes.wso2.jms.configs.Wso2Config;

public class Wso2QueuePublisher {

	private final static Logger LOG = Logger.getLogger(Wso2QueuePublisher.class);
	private static QueueConnection queueConnection;
	private static QueueSession queueSession;

	public static void main(String[] args) throws NamingException, JMSException {
		BasicConfigurator.configure();
		Wso2QueuePublisher publisher = new Wso2QueuePublisher();
		publisher.sendMessages(500);
	}

	private void sendMessages(int qtdeMessages) throws NamingException, JMSException {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, Wso2Config.QPID_ICF);
		properties.put(Wso2Config.CF_NAME_PREFIX + Wso2Config.CF_NAME, Wso2Config.getTCPConnectionURL());
		properties.put(Wso2Config.QUEUE_NAME_PREFIX + Wso2Config.QUEUE_NAME, Wso2Config.QUEUE_NAME);
		InitialContext ctx = new InitialContext(properties);
		QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(Wso2Config.CF_NAME);
		queueConnection = connFactory.createQueueConnection();
		queueConnection.start();
		queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		Queue queue = (Queue) ctx.lookup(Wso2Config.QUEUE_NAME);
		QueueSender queueSender = queueSession.createSender(queue);
		for (int i = 1; i <= qtdeMessages; i++) {
			TextMessage textMessage = queueSession.createTextMessage("Test Message " + i);
			LOG.info("Sending message --> " + textMessage.getText());
			queueSender.send(textMessage);
		}
		queueSender.close();
		queueSession.close();
		queueConnection.close();
	}

}
