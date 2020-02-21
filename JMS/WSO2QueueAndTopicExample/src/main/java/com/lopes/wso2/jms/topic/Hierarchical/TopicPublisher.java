package com.lopes.wso2.jms.topic.Hierarchical;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicPublisher {

	private static String CARBON_CLIENT_ID = "carbon";
	private static String CARBON_DEFAULT_HOSTNAME = "localhost";
	private static String CARBON_DEFAULT_PORT = "5676";
	private static String CARBON_VIRTUAL_HOST_NAME = "carbon";
	private static final String CF_NAME = "qpidConnectionfactory";
	private static final String CF_NAME_PREFIX = "connectionfactory.";
	public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
	String password = "admin";
	String topicName_1 = "Games";
	String topicName_2 = "Games.Cricket";
	String topicName_3 = "Games.Cricket.SL";
	String topicName_4 = "Games.Cricket.India";
	String topicName_5 = "Games.Cricket.India.Delhi";
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
		properties.put("topic." + topicName_1, topicName_1);
		properties.put("topic." + topicName_2, topicName_2);
		properties.put("topic." + topicName_3, topicName_3);
		properties.put("topic." + topicName_4, topicName_4);
		properties.put("topic." + topicName_5, topicName_5);
		return new InitialContext(properties);
	}

	public void publishMessage() throws NamingException, JMSException {

		InitialContext ctx = init();
		TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(CF_NAME);
		TopicConnection topicConnection = connFactory.createTopicConnection();
		topicConnection.start();
		TopicSession topicSession = topicConnection.createTopicSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		Topic topic1 = (Topic) ctx.lookup(topicName_1);
		Topic topic2 = (Topic) ctx.lookup(topicName_2);
		Topic topic3 = (Topic) ctx.lookup(topicName_3);
		Topic topic4 = (Topic) ctx.lookup(topicName_4);
		Topic topic5 = (Topic) ctx.lookup(topicName_5);

		javax.jms.TopicPublisher topicPublisher1 = topicSession.createPublisher(topic1);
		javax.jms.TopicPublisher topicPublisher2 = topicSession.createPublisher(topic2);
		javax.jms.TopicPublisher topicPublisher3 = topicSession.createPublisher(topic3);
		javax.jms.TopicPublisher topicPublisher4 = topicSession.createPublisher(topic4);
		javax.jms.TopicPublisher topicPublisher5 = topicSession.createPublisher(topic5);

		TextMessage textMessage1 = topicSession.createTextMessage("Message for Games");
		TextMessage textMessage2 = topicSession.createTextMessage("Message for Cricket");
		TextMessage textMessage3 = topicSession.createTextMessage("Message for SL");
		TextMessage textMessage4 = topicSession.createTextMessage("Message for India");
		TextMessage textMessage5 = topicSession.createTextMessage("Message for Delhi");
		topicPublisher1.publish(textMessage1);
		topicPublisher2.publish(textMessage2);
		topicPublisher3.publish(textMessage3);
		topicPublisher4.publish(textMessage4);
		topicPublisher5.publish(textMessage5);
		topicSession.close();
		topicConnection.close();
	}

}
