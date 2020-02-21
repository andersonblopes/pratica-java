package com.lopes.wso2.jms.configs;

public class Wso2Config {

	private static final String PASSWORD = "admin";
	private static final String USER_NAME = "admin";

	public static final String CARBON_CLIENT_ID = "carbon";
	public static final String CARBON_DEFAULT_HOSTNAME = "localhost";
	public static final String CARBON_DEFAULT_PORT = "5676";
	public static final String CARBON_VIRTUAL_HOST_NAME = "carbon";
	public static final String CF_NAME = "qpidConnectionfactory";
	public static final String CF_NAME_PREFIX = "connectionfactory.";
	public static final String QPID_ICF = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
	public static final String QUEUE_NAME = "digitalisQueue";
	public static final String TOPIC_NAME = "DIGITALISTopic";
	public static final String QUEUE_NAME_PREFIX = "queue.";

	public static String getTCPConnectionURL() {
		return new StringBuffer().append("amqp://").append(USER_NAME).append(":").append(PASSWORD).append("@")
				.append(Wso2Config.CARBON_CLIENT_ID).append("/").append(Wso2Config.CARBON_VIRTUAL_HOST_NAME)
				.append("?brokerlist='tcp://").append(Wso2Config.CARBON_DEFAULT_HOSTNAME).append(":")
				.append(Wso2Config.CARBON_DEFAULT_PORT).append("'").toString();
	}
}
