package com.lopes.junit.spring.dao;

import org.springframework.stereotype.Component;

import com.lopes.junit.spring.dto.Ticket;

@Component
public class TicketDAOImpl implements TicketDAO {

	@Override
	public int createTicket(Ticket ticket) {
		return 1;
	}

}
