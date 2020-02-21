package com.lopes.wso2.jms.topic.Hierarchical;

import javax.jms.JMSException;
import javax.naming.NamingException;

public class Main {

	public static void main(String[] args) throws NamingException, JMSException, InterruptedException {
		HierarchicalTopic hierarchicalTopic = new HierarchicalTopic();
		hierarchicalTopic.start();
		while (!hierarchicalTopic.isSubscriptionComplete()) {
			Thread.sleep(500);
		}
		TopicPublisher topicPublisher = new TopicPublisher();
		topicPublisher.publishMessage();
	}

}
