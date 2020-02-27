package com.lopes.ecommerce.test.training;

import com.lopes.ecommerce.model.Client;
import com.lopes.ecommerce.model.Gender;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

public class MappingEnumerationsTest extends AbstractApplicationTest {

    @Test
    public void mustInsertEnumerationValueString() {

        Client client = new Client();
        client.setName("Josef Smith");
        client.setGender(Gender.MALE);

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.clear();// Clean cache level 1

        Client clientPersisted = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(clientPersisted);
    }
}
