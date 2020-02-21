package org.digitalis.ws.soap.server;

import javax.jws.WebService;

@WebService(endpointInterface = "org.digitalis.ws.soap.server.CalculatorI")
public class CalculatorImpl implements CalculatorI {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

}