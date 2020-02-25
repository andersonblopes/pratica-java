package com.lopes.ecommerce.test.training.relationships;

import com.lopes.ecommerce.model.*;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationshipManyToOneTest extends AbstractApplicationTest {

    @Test
    public void mustTestRelationshipManyToOneOrder(){

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

        Order orderPersisted = entityManager.find(Order.class,order.getId());
        Assert.assertNotNull(orderPersisted);
        Assert.assertNotNull(orderPersisted.getClient());

    }

    @Test
    public void mustTestRelationshipManyToOneOrderItem(){
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

        OrderItem orderItemPersisted = entityManager.find(OrderItem.class,orderItem.getId());
        Assert.assertNotNull(orderItemPersisted);
        Assert.assertNotNull(orderItemPersisted.getOrder());
        Assert.assertNotNull(orderItemPersisted.getProduct());

    }
}
