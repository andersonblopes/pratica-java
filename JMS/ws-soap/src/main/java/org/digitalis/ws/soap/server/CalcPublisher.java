package org.digitalis.ws.soap.server;

import javax.xml.ws.Endpoint;

public class CalcPublisher {

	public static void main(String[] args) {
		Endpoint ep = Endpoint.create(new CalculatorImpl());

		System.out.println("Start WS SOAP...");

		ep.publish("http://127.0.0.1:10000/calcServer");
	}

}
