package com.lopes.junit5.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.lopes.junit5.model.OrderDAO;
import com.lopes.junit5.model.dto.Order;
import com.lopes.junit5.service.exception.BOException;

class OrderServiceImplTest {

	private static final long ORDER_ID = 123L;
	@Mock
	OrderDAO dao;
	private OrderServiceImpl serviceImpl;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		serviceImpl = new OrderServiceImpl();
		serviceImpl.setDao(dao);
	}

	@Test
	void placeOrder_Shuld_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.create(order)).thenReturn(new Integer(1));

		boolean result = serviceImpl.placeOrder(order);

		Assertions.assertTrue(result);
		Mockito.verify(dao, Mockito.times(1)).create(order);

	}

	@Test
	void placeOrder_Shuld_NOT_Create_An_Order() throws SQLException, BOException {

		Order order = new Order();
		Mockito.when(dao.create(order)).thenReturn(new Integer(0));

		boolean result = serviceImpl.placeOrder(order);

		Assertions.assertFalse(result);
		Mockito.verify(dao, Mockito.times(1)).create(order);

	}

	@SuppressWarnings("unchecked")
	@Test
	void placeOrder_Shuld_Throw_BOException() throws SQLException, BOException {

		Mockito.when(dao.create(Mockito.any(Order.class))).thenThrow(SQLException.class);

		Assertions.assertThrows(BOException.class, () -> {
			serviceImpl.placeOrder(Mockito.any(Order.class));
		});

	}

	@Test
	public void cancelOrder_Should_Cancel_Order() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.read(ORDER_ID)).thenReturn(order);

		Mockito.when(dao.update(order)).thenReturn(1);

		boolean result = serviceImpl.cancelOrder(ORDER_ID);

		Assertions.assertTrue(result);

		Mockito.verify(dao, Mockito.times(1)).read(ORDER_ID);
		Mockito.verify(dao, Mockito.times(1)).update(order);
	}

	@Test
	public void cancelOrder_Should_NOT_Cancel_Order() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.read(ORDER_ID)).thenReturn(order);

		Mockito.when(dao.update(order)).thenReturn(0);

		boolean result = serviceImpl.cancelOrder(ORDER_ID);

		Assertions.assertFalse(result);

		Mockito.verify(dao, Mockito.times(1)).read(ORDER_ID);
		Mockito.verify(dao, Mockito.times(1)).update(order);
	}

	@Test
	public void cancelOrder_Should_Throw_BOException_On_Read() throws SQLException, BOException {
		Mockito.when(dao.read(ORDER_ID)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {
			serviceImpl.cancelOrder(ORDER_ID);
		});
	}

	@Test
	public void cancelOrder_Should_Throw_BOException_On_Update() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.read(ORDER_ID)).thenReturn(order);

		Mockito.when(dao.update(order)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {
			serviceImpl.cancelOrder(ORDER_ID);
		});
	}

	@Test
	public void deleteOrder_Deletes_Orders() throws SQLException, BOException {
		Mockito.when(dao.delete(ORDER_ID)).thenReturn(1);
		OrderServiceImpl serviceImpl2 = serviceImpl;
		boolean result = serviceImpl2.deleteOrder(ORDER_ID);

		Assertions.assertTrue(result);

		Mockito.verify(dao, Mockito.times(1)).delete(ORDER_ID);

	}

	@Test
	public void deleteOrder_NOT_Deletes_Orders() throws SQLException, BOException {
		Mockito.when(dao.delete(Mockito.anyLong())).thenReturn(0);
		OrderServiceImpl serviceImpl2 = serviceImpl;
		boolean result = serviceImpl2.deleteOrder(ORDER_ID);

		Assertions.assertFalse(result);

		Mockito.verify(dao, Mockito.times(1)).delete(ORDER_ID);

	}

	@Test
	public void deleteOrder_Should_Throw_BOException() throws SQLException, BOException {
		Mockito.when(dao.delete(ORDER_ID)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {
			serviceImpl.deleteOrder(ORDER_ID);
		});
	}

}
