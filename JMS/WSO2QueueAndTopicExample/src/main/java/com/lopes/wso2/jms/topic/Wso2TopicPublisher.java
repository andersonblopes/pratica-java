package com.lopes.wso2.jms.topic;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.lopes.wso2.jms.configs.Wso2Config;
import com.lopes.wso2.jms.queue.Wso2QueuePublisher;

public class Wso2TopicPublisher {

	private final static Logger LOG = Logger.getLogger(Wso2QueuePublisher.class);

	public static void main(String[] args) throws NamingException, JMSException {
		BasicConfigurator.configure();
		Wso2TopicPublisher wso2TopicPublisher = new Wso2TopicPublisher();
		wso2TopicPublisher.publishMessage(10000);
	}

	private void publishMessage(int qtdeMessages) throws NamingException, JMSException {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, Wso2Config.QPID_ICF);
		properties.put(Wso2Config.CF_NAME_PREFIX + Wso2Config.CF_NAME, Wso2Config.getTCPConnectionURL());
		InitialContext ctx = new InitialContext(properties);
		TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(Wso2Config.CF_NAME);
		TopicConnection topicConnection = connFactory.createTopicConnection();
		topicConnection.start();
		TopicSession topicSession = topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
		Topic topic = topicSession.createTopic(Wso2Config.TOPIC_NAME);
		TopicPublisher topicPublisher = topicSession.createPublisher(topic);
		for (int i = 1; i <= qtdeMessages; i++) {
			TextMessage textMessage = topicSession.createTextMessage("Test Message " + i);
			LOG.info("Sending message --> " + textMessage.getText());
			topicPublisher.publish(textMessage);
		}
		topicPublisher.close();
		topicSession.close();
		topicConnection.stop();
		topicConnection.close();
	}
}
