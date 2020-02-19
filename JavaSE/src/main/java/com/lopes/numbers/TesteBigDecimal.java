package com.lopes.java.numbers;

import java.math.BigDecimal;

public class TesteBigDecimal {

	public static void main(String[] args) {

		Double d1 = 0.1;
		Double d2 = 0.2;

		// Imprecisão na soma de 2 valores Double
		System.out.println("Imprecisão na soma de 2 valores Double: " + (d1 + d2));

		BigDecimal big1 = new BigDecimal(0.1);
		BigDecimal big2 = new BigDecimal(0.2);

		// Imprecisão ao enviar double no construtor
		System.out.println("Imprecisão ao enviar double no construtor" + (big1.add(big2)));

		big1 = new BigDecimal("0.1");
		big2 = new BigDecimal("0.2");

		// Precisão obtida enviando o valor como String no construtor
		System.out.println("Precisão obtida enviando o valor como String no construtor: " + (big1.add(big2)));

	}

}
