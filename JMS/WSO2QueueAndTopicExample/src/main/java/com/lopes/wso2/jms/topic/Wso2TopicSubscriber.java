package com.lopes.wso2.jms.topic;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.lopes.wso2.jms.configs.Wso2Config;
import com.lopes.wso2.jms.queue.Wso2QueuePublisher;

public class Wso2TopicSubscriber {

	private final static Logger LOG = Logger.getLogger(Wso2QueuePublisher.class);

	private TopicConnection topicConnection;
	private TopicSession topicSession;

	public static void main(String[] args) throws NamingException, JMSException {
		BasicConfigurator.configure();
		Wso2TopicSubscriber wso2TopicSubscriber = new Wso2TopicSubscriber();
		TopicSubscriber subscriber = wso2TopicSubscriber.subscribe();
		wso2TopicSubscriber.receive(subscriber);
	}

	public void receive(TopicSubscriber topicSubscriber) throws JMSException {
		try {
			while (true) {
				Message message = topicSubscriber.receive();
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					LOG.info("Got message from topic subscriber = " + textMessage.getText());
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			topicSubscriber.close();
			topicSession.close();
			topicConnection.stop();
			topicConnection.close();
		}

	}

	public TopicSubscriber subscribe() throws NamingException, JMSException {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, Wso2Config.QPID_ICF);
		properties.put(Wso2Config.CF_NAME_PREFIX + Wso2Config.CF_NAME, Wso2Config.getTCPConnectionURL());
		InitialContext ctx = new InitialContext(properties);
		TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup(Wso2Config.CF_NAME);
		topicConnection = connFactory.createTopicConnection();
		topicConnection.start();
		topicSession = topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
		Topic topic = topicSession.createTopic(Wso2Config.TOPIC_NAME);
		TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
		return topicSubscriber;
	}
}
