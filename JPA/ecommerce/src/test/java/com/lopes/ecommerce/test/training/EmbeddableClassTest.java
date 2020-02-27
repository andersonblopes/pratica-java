package com.lopes.ecommerce.test.training;

import com.lopes.ecommerce.model.Client;
import com.lopes.ecommerce.model.DeliveryAddress;
import com.lopes.ecommerce.model.Order;
import com.lopes.ecommerce.model.OrderStatus;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmbeddableClassTest extends AbstractApplicationTest {

    @Test
    public void mustPersistEmbeddableClass() {
        Client client = entityManager.find(Client.class, 1);

        DeliveryAddress address = new DeliveryAddress();
        address.setStreetAddress("Grand Ave Ste B");
        address.setAddressLine2("2045 W");
        address.setCity("Chicago");
        address.setStateProvinceRegion("IL, US");
        address.setPostalZipCode("60612-1577");

        Order order = new Order();
        order.setDeliveryAddress(address);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.WAIT);
        order.setTotal(new BigDecimal("25000"));
        order.setClient(client);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order orderPersisted = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(orderPersisted);
        Assert.assertNotNull(orderPersisted.getClient());
        Assert.assertEquals(orderPersisted.getDeliveryAddress().getPostalZipCode(), order.getDeliveryAddress().getPostalZipCode());
        Assert.assertEquals(orderPersisted.getDeliveryAddress().getCity(), order.getDeliveryAddress().getCity());
    }
}
