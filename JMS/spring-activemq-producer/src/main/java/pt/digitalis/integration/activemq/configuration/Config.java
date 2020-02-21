package pt.digitalis.integration.activemq.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("digitalis-queue");
	}

}
