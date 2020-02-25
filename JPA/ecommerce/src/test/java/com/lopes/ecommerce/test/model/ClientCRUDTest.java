package com.lopes.ecommerce.test.model;

import com.lopes.ecommerce.model.Client;
import com.lopes.ecommerce.model.Gender;
import com.lopes.ecommerce.model.Order;
import com.lopes.ecommerce.model.Product;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

public class ClientCRUDTest extends AbstractApplicationTest {

    @Test
    public void mustInsertClient() {
        Client client = new Client();
        client.setName("Helena Lopes");
        client.setGender(Gender.FEMALE);

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientPersisted = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(clientPersisted);

    }

    @Test
    public void mustUpdateClient() {
        String newName = "Elaine Cristina Lopes";
        Client client = entityManager.find(Client.class, 2);

        entityManager.getTransaction().begin();
        client.setName(newName);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client clientUpdated = entityManager.find(Client.class, 2);
        Assert.assertEquals(newName, clientUpdated.getName());

    }

    @Test
    public void mustDeleteClient() {
        Client client = entityManager.find(Client.class, 1);

        entityManager.getTransaction().begin();
        client.getOrders().forEach(order -> order.getOrderItems().forEach(orderItem -> entityManager.remove(orderItem)));
        client.getOrders().forEach(order -> entityManager.remove(order));
        entityManager.remove(client);
        entityManager.getTransaction().commit();

        Client clientRemoved = entityManager.find(Client.class, 1);
        Assert.assertNull(clientRemoved);
    }

    @Test
    public void mustFindClient() {
        Client client = entityManager.find(Client.class, 2);
        Assert.assertNotNull(client);
    }
}
