package com.lopes.junit5.test.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.lopes.junit5.calculator.CalculatorImpl;

class CalculatorImplTest {

	@Test
	void givenValidParametersWhenAddThenReturnResult() {
		CalculatorImpl calculatorImpl = new CalculatorImpl();
		int result = calculatorImpl.add(3, 5);
		assertEquals(8, result);

	}

}
