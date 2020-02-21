package com.lopes.wso2.jms.topic.Hierarchical;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HierarchicalTopic extends Thread {

	private static String CARBON_CLIENT_ID = "carbon";
	private static String CARBON_DEFAULT_HOSTNAME = "localhost";
	private static String CARBON_DEFAULT_PORT = "5676";
	private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
	private static final String CF_NAME = "qpidConnectionfactory";
	private static final String CF_NAME_PREFIX = "connectionfactory.";
	public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
	private boolean isSubscriptionComplete = false;
	String password = "admin";
	String topicName_1 = "Games";
	String topicName_2 = "Games.Cricket";
	String topicName_3 = "Games.Cricket.SL";
	String topicName_4 = "Games.Cricket.India";
	String topicName_5 = "Games.Cricket.India.Delhi";
	String topicName_6 = "Games.Cricket.*";
	String topicName_7 = "Games.Cricket.#";

	String userName = "admin";

	private String getTCPConnectionURL(String username, String password) {
		return new StringBuffer().append("amqp://").append(username).append(":").append(password).append("@")
				.append(CARBON_CLIENT_ID).append("/").append(CARBON_VIRTUAL_HOST_NAME).append("?brokerlist='tcp://")
				.append(CARBON_DEFAULT_HOSTNAME).append(":").append(CARBON_DEFAULT_PORT).append("'").toString();
	}

	private InitialContext init() throws NamingException {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, QPID_ICF);
		properties.put(CF_NAME_PREFIX + CF_NAME, getTCPConnectionURL(userName, password));
		properties.put("topic." + topicName_6, topicName_6);
		properties.put("topic." + topicName_7, topicName_7);
		return new InitialContext(properties);
	}

	public boolean isSubscriptionComplete() {
		return this.isSubscriptionComplete;
	}

	@Override
	public void run() {
		try {
			subscribe();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void subscribe() throws NamingException, JMSException {
		InitialContext ctx = init();
		TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(CF_NAME);
		TopicConnection topicConnection = connFactory.createTopicConnection();
		topicConnection.start();

		TopicSession topicSession1 = topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		TopicSession topicSession2 = topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);

		Topic topic1 = topicSession1.createTopic(topicName_1);
		Topic topic2 = topicSession1.createTopic(topicName_2);
		Topic topic3 = topicSession1.createTopic(topicName_3);
		Topic topic4 = topicSession1.createTopic(topicName_4);
		Topic topic5 = topicSession1.createTopic(topicName_5);
		Topic topic6 = (Topic) ctx.lookup(topicName_6);
		Topic topic7 = (Topic) ctx.lookup(topicName_7);
		TopicSubscriber topicSubscriber1 = topicSession1.createSubscriber(topic6);
		TopicSubscriber topicSubscriber2 = topicSession2.createSubscriber(topic7);

		isSubscriptionComplete = true;
		Message message1;
		System.out.println(" Receiving messages for " + topicName_6 + " :");
		while ((message1 = topicSubscriber1.receive(5000)) != null) {
			if (message1 instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message1;
				System.out.println("Got Message from subscriber1 => " + textMessage.getText());
			}
		}

		Message message2;
		System.out.println(" Receiving messages for " + topicName_7 + " :");
		while ((message2 = topicSubscriber2.receive(5000)) != null) {
			if (message2 instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message2;
				System.out.println("Got Message from subscriber2 => " + textMessage.getText());
			}
		}

		topicSubscriber1.close();
		topicSubscriber2.close();
		topicSession1.close();
		topicSession2.close();
		topicConnection.stop();
		topicConnection.close();
	}
}
