package com.lopes.wso2.jms.queue;

import java.util.Properties;

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

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.lopes.wso2.jms.configs.Wso2Config;

public class Wso2QueueSubscriber {

	private static final Logger LOG = Logger.getLogger(Wso2QueueSubscriber.class);
	private static QueueConnection queueConnection;
	private static QueueSession queueSession;

	public static void main(String[] args) throws NamingException, JMSException {
		BasicConfigurator.configure();
		Wso2QueueSubscriber subscriber = new Wso2QueueSubscriber();
		MessageConsumer consumer = subscriber.registerSubscriber();
		subscriber.receiveMessages(consumer);
	}

	public void receiveMessages(MessageConsumer consumer) throws NamingException, JMSException {
		for (int i = 0; i < 100; i++) {
			TextMessage message = (TextMessage) consumer.receive();
			LOG.info("Got message from queue receiver==>" + message.getText());
		}
		consumer.close();
		queueSession.close();
		queueConnection.stop();
		queueConnection.close();
	}

	public MessageConsumer registerSubscriber() throws NamingException, JMSException {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, Wso2Config.QPID_ICF);
		properties.put(Wso2Config.CF_NAME_PREFIX + Wso2Config.CF_NAME, Wso2Config.getTCPConnectionURL());
		properties.put("queue." + Wso2Config.QUEUE_NAME, Wso2Config.QUEUE_NAME);
		InitialContext ctx = new InitialContext(properties);
		QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup(Wso2Config.CF_NAME);
		queueConnection = connFactory.createQueueConnection();
		queueConnection.start();
		queueSession = queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		Queue queue = (Queue) ctx.lookup(Wso2Config.QUEUE_NAME);
		MessageConsumer consumer = queueSession.createConsumer(queue);
		return consumer;
	}

}
