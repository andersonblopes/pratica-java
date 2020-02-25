package com.lopes.ecommerce.test.training.relationships;

import com.lopes.ecommerce.model.*;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationshipOneToOneTest extends AbstractApplicationTest {

    @Test
    public void mustTestRelationshipOneToOne(){

        Order order = entityManager.find(Order.class, 1);

        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.setNumber("1234");
        creditCardPayment.setPaymentStatus(PaymentStatus.PROCESS);
        creditCardPayment.setOrder(order);

        entityManager.getTransaction().begin();
        entityManager.persist(creditCardPayment);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderVerified = entityManager.find(Order.class,order.getId());
        Assert.assertNotNull(orderVerified.getCreditCardPayment());

    }

}
