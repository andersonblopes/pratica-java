package com.lopes.ecommerce.test.model;

import com.lopes.ecommerce.model.Product;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductPersistTest extends AbstractApplicationTest {

    @Test
    public void mustPersistProduct() {

        Product product = new Product(2, "iPhone 11 Pro", "Welcome to the first iPhone powerful enough to be called Pro.", new BigDecimal("999.99"));

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        //Force searching the database
        entityManager.clear();

        Product product1Persisted = entityManager.find(Product.class, product.getId());

        Assert.assertNotNull(product1Persisted);
    }

    @Test
    public void mustRemoveProduct() {

        Product product = entityManager.find(Product.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        Product product1Removed = entityManager.find(Product.class, 3);

        Assert.assertNull(product1Removed);
    }

    @Test
    public void mustUpdateProduct() {

        Product product = new Product(1, "iPhone 11 Pro", "Welcome to the first iPhone powerful enough to be called Pro.", new BigDecimal("999.99"));

        entityManager.getTransaction().begin();
         entityManager.merge(product);
        entityManager.getTransaction().commit();

        //Force searching the database
        entityManager.clear();

        Product product1Updated = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(product1Updated);
    }

    @Test
    public void mustUpdateManagedProduct() {

        BigDecimal newPrice = new BigDecimal("899.99");

        Product product = entityManager.find(Product.class, 1);

        entityManager.getTransaction().begin();
        product.setPrice(newPrice);
        entityManager.getTransaction().commit();

        //Force searching the database
        entityManager.clear();

        Product product1Updated = entityManager.find(Product.class, 1);
        Assert.assertEquals(newPrice, product1Updated.getPrice());
    }

}
