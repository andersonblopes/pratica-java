package com.lopes.ecommerce.test.training.relationships;

import com.lopes.ecommerce.model.CreditCardPayment;
import com.lopes.ecommerce.model.Invoice;
import com.lopes.ecommerce.model.Order;
import com.lopes.ecommerce.model.PaymentStatus;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class RelationshipOneToOneTest extends AbstractApplicationTest {

    @Test
    public void mustTestRelationshipOneToOneCreditCardPayment(){

        Order order = entityManager.find(Order.class, 1);

        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.setNumber("1234");
        creditCardPayment.setPaymentStatus(PaymentStatus.PROCESS);
        creditCardPayment.setOrder(order);

        entityManager.getTransaction().begin();
        entityManager.persist(creditCardPayment);
        entityManager.getTransaction().commit();

        entityManager.clear();// Clean cache level 1

        Order orderVerified = entityManager.find(Order.class,order.getId());
        Assert.assertNotNull(orderVerified.getCreditCardPayment());

    }

    @Test
    public void mustTestRelationshipOneToOneInvoice(){

        Order order = entityManager.find(Order.class, 1);

        Invoice invoice = new Invoice();
        invoice.setIssueDate(new Date());
        invoice.setXml("TESTE");
        invoice.setOrder(order);

        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();

        entityManager.clear();// Clean cache level 1

        Order orderVerified = entityManager.find(Order.class,order.getId());
        Assert.assertNotNull(orderVerified);
        Assert.assertNotNull(orderVerified.getInvoice());

    }

}
