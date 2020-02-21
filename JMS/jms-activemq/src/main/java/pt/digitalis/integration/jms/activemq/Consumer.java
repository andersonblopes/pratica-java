package pt.digitalis.integration.jms.activemq;

import java.util.List;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.qpid.jms.JmsConnectionFactory;

class Consumer {

	private static final Logger LOG = Logger.getLogger(Consumer.class.getName());

	public static void main(String[] args) throws JMSException {

		long tempoInicio = System.currentTimeMillis();

		JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
		Connection connection = factory.createConnection("admin", "password");
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Queue queue = session.createQueue("digitalis-queue");

		MessageConsumer consumer = session.createConsumer(queue);

		lerDaFila(null, session, consumer, queue);

		connection.close();

		LOG.info("Tempo Total: " + (System.currentTimeMillis() - tempoInicio) / 1000 + "s");
	}

	private static void lerDaFila(List<?> lista, Session session, MessageConsumer consumer, Queue queue)
			throws JMSException {
		while (session.createBrowser(queue).getEnumeration().hasMoreElements()) {
			TextMessage message = (TextMessage) consumer.receive();
			LOG.info("Process message ==>  " + message.getText());
		}

	}

}