package com.lopes.ecommerce.test.training.relationships;

import com.lopes.ecommerce.model.Order;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

public class RemoveRelatedEntity extends AbstractApplicationTest {

    @Test
    public void mustRemoveRelatedEntity(){
        Order order = entityManager.find(Order.class, 1);

        Assert.assertFalse(order.getOrderItems().isEmpty());

        entityManager.getTransaction().begin();
        order.getOrderItems().forEach(orderItem -> entityManager.remove(orderItem));
        entityManager.remove(order);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderVerified = entityManager.find(Order.class, 1);
        Assert.assertNull(orderVerified);


    }
}
