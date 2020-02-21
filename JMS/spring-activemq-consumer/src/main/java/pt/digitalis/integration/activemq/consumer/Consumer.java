package pt.digitalis.integration.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = "digitalis-queue")
	public void listener(String message) {
		logger.info("Received {} ", message);
	}
}
