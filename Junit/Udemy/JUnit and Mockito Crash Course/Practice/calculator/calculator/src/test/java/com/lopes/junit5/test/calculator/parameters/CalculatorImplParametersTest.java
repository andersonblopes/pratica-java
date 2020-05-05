package com.lopes.junit5.test.calculator.parameters;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lopes.junit5.calculator.CalculatorImpl;

@RunWith(Parameterized.class)
public class CalculatorImplParametersTest {

	// Define parameters
	private int a;
	private int b;
	private int expectedResult;

	// Create constructor
	public CalculatorImplParametersTest(int a, int b, int result) {
		this.a = a;
		this.b = b;
		this.expectedResult = result;
	}

	@Parameters
	public static Collection<Integer[]> data() {
		return Arrays.asList(new Integer[][] { { 1, 2, 3 }, { -4, -5, -9 }, { 7, -8, -1 } });
	}

	@Test
	public void givenValidParametersWhenAddThenReturnResult() {
		CalculatorImpl calculatorImpl = new CalculatorImpl();
		int result = calculatorImpl.add(a, b);
		assertEquals(expectedResult, result);

	}

}
