package pt.digitalis.integration.jms.activemq;

import java.util.List;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.qpid.jms.JmsConnectionFactory;

class Producer {

	private static final Logger LOG = Logger.getLogger(Producer.class.getName());

	public static void main(String[] args) throws Exception {

		long tempoInicio = System.currentTimeMillis();

		JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
		Connection connection = factory.createConnection("admin", "password");
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("digitalis-queue");

		MessageProducer producer = session.createProducer(destination);
		enviarParaFila(null, session, producer);

		connection.close();
		LOG.info("Tempo Total: " + (System.currentTimeMillis() - tempoInicio) / 1000 + "s");
	}

	private static void enviarParaFila(List<?> lista, Session session, MessageProducer producer) throws JMSException {
		for (int i = 0; i < 1000; i++) {
			String response = "Message with ID: " + i;
			TextMessage msg = session.createTextMessage(response);
			producer.send(msg);
			LOG.info("Message Submit: " + response);
		}
	}
}