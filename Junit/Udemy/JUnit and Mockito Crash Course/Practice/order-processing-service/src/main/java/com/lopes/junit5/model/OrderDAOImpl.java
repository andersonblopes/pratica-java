package com.lopes.junit5.model;

import java.sql.SQLException;

import com.lopes.junit5.model.dto.Order;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int create(Order oreder) throws SQLException {
		return 0;
	}

	@Override
	public Order read(Long id) throws SQLException {
		return null;
	}

	@Override
	public int update(Order oreder) throws SQLException {
		return 0;
	}

	@Override
	public int delete(Long id) throws SQLException {
		return 0;
	}

}
