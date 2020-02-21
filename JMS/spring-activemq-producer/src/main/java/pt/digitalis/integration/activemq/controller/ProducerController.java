package pt.digitalis.integration.activemq.controller;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

	private final Logger logger = LoggerFactory.getLogger(ProducerController.class);

	@Autowired
	private Queue queue;

	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("/test")
	public String test() {
		long tempoInicio = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			String text = "Mesage ==> " + i;
			jmsTemplate.convertAndSend(queue, text);
			logger.info("Submit " + text);
		}
		return "Submit to queue in: " + ((System.currentTimeMillis() - tempoInicio) / 1000) + "s";
	}
}
