package com.lopes.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ATest {

	@Mock
	B b;

	private A a;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);

	}

	@Test
	void usesVoidMethodShouldCallTheVoidMethod() throws Exception {
		Mockito.doNothing().when(b).voidMethod();
		Assertions.assertSame(1, a.usesVoidMethod());
		Mockito.verify(b).voidMethod();
	}

	@Test
	void usesVoidMethodThrowRuntimeException() throws Exception {
		Mockito.doThrow(Exception.class).when(b).voidMethod();
		Assertions.assertThrows(RuntimeException.class, () -> {
			a.usesVoidMethod();
		});
	}

	@Test
	void testConsecutiveCalls() throws Exception {
		Mockito.doNothing().doThrow(Exception.class).when(b).voidMethod();
		Assertions.assertThrows(RuntimeException.class, () -> {
			a.usesVoidMethod();
			Mockito.verify(b).voidMethod();
			a.usesVoidMethod();
		});
		Mockito.verify(b, Mockito.times(2)).voidMethod();
	}

}
