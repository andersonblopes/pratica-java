package com.lopes.junit.spring.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lopes.junit.spring.dao.TicketDAO;
import com.lopes.junit.spring.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int EXPECTED = 1;
	private static final String PHONE = "1234567890";
	private static final String PASSENGER_NAME = "Anderson";

	@Mock
	TicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenBuyTicketThenReturnValidValue() {
		Mockito.when(dao.createTicket(Mockito.any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket(PASSENGER_NAME, PHONE);
		assertEquals(EXPECTED, result);
	}

}
