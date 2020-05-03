package com.lopes.junit5.service;

import java.sql.SQLException;

import com.lopes.junit5.model.OrderDAO;
import com.lopes.junit5.model.dto.Order;
import com.lopes.junit5.service.exception.BOException;

public class OrderServiceImpl implements OrderService {

	private OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = getDao().create(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(Long id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("cancelled");
			int result = getDao().update(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteOrder(Long id) throws BOException {
		try {
			int result = getDao().delete(id);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

}
