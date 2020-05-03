package com.lopes.junit5.model;

import java.sql.SQLException;

import com.lopes.junit5.model.dto.Order;

public interface OrderDAO {

	int create(Order order) throws SQLException;

	Order read(Long id) throws SQLException;

	int update(Order order) throws SQLException;

	int delete(Long id) throws SQLException;
}
