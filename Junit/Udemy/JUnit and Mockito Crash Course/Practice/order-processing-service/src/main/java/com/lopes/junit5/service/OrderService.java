package com.lopes.junit5.service;

import com.lopes.junit5.model.dto.Order;
import com.lopes.junit5.service.exception.BOException;

public interface OrderService {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(Long id) throws BOException;

	boolean deleteOrder(Long id) throws BOException;

}
