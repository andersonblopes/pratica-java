package com.lopes.ecommerce.test.relationships;

import com.lopes.ecommerce.model.*;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationshipOneToManyTest extends AbstractApplicationTest {

    @Test
    public void mustTestRelationshipOneToManyOrder(){

        Client client = entityManager.find(Client.class, 1);
        Order order = new Order();
        order.setOrderStatus(OrderStatus.WAIT);
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(BigDecimal.TEN);

        order.setClient(client);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientVerified = entityManager.find(Client.class,order.getClient().getId());
        Assert.assertFalse(clientVerified.getOrders().isEmpty());

    }

    @Test
    public void mustTestRelationshipOneToManyOrderItem(){

        Client client = entityManager.find(Client.class, 1);
        Product product = entityManager.find(Product.class, 1);

        Order order = new Order();
        order.setOrderStatus(OrderStatus.WAIT);
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(BigDecimal.TEN);
        order.setClient(client);

        OrderItem orderItem = new OrderItem();
        orderItem.setAmount(500);
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setProductPrice(new BigDecimal("55000"));

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.persist(orderItem);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderVerified = entityManager.find(Order.class,order.getId());
        Assert.assertFalse(orderVerified.getOrderItems().isEmpty());

    }

}
