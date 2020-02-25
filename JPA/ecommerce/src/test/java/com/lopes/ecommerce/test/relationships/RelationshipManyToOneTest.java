package com.lopes.ecommerce.test.relationships;

import com.lopes.ecommerce.model.Client;
import com.lopes.ecommerce.model.Order;
import com.lopes.ecommerce.model.OrderStatus;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationshipManyToOneTest extends AbstractApplicationTest {

    @Test
    public void mustTestRelationshipManyToOne(){
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
}
