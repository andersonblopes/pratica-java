package com.lopes.junit5.service;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ListTest {

//	@Spy // Semi Mock object
//	List<String> myList = new ArrayList<String>();

	@Mock
	List<String> myList = new ArrayList<String>();

	@BeforeEach
	public void setup() {
		System.out.println("Setup");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() {

		myList.add("Anderson");
		myList.add("Elaine");
		myList.add("Helena");

		Mockito.doReturn(4).when(myList).size();
		assertSame(4, myList.size());

	}

	@AfterEach
	public void teardown() {
		System.out.println("teardown");
		myList = null;
	}

}
