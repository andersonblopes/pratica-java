package com.lopes.ecommerce.test.model;

import com.lopes.ecommerce.model.Product;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductCRUDTest extends AbstractApplicationTest {

    @Test
    public void mustInsertProduct() {
        Product product = new Product(null, "Product Test 3", "", new BigDecimal("100.00"));

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productPersisted = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(productPersisted);

    }

    @Test
    public void mustUpdateProduct() {
        String newDescription = "Product Test 1 description";
        Product product = entityManager.find(Product.class, 1);

        entityManager.getTransaction().begin();
        product.setDescription(newDescription);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product productUpdated = entityManager.find(Product.class, 1);
        Assert.assertEquals(newDescription, productUpdated.getDescription());

    }

    @Test
    public void mustDeleteProduct() {
        Product product = entityManager.find(Product.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        Product productRemoved = entityManager.find(Product.class, 1);
        Assert.assertNull(productRemoved);

    }

    @Test
    public void mustFindProduct() {
        Product product = entityManager.find(Product.class, 3);
        Assert.assertNotNull(product);
    }
}
