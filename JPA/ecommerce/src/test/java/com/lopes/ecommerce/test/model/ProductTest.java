package com.lopes.ecommerce.test.model;

import com.lopes.ecommerce.model.Product;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest extends AbstractApplicationTest {

    @Test
    public void mustFindOneProduct(){
        Product product = entityManager.find(Product.class, 1);
        Assert.assertNotNull(product);
    }

    @Test
    public void mustFindOneProductByReference(){
        Product product = entityManager.getReference(Product.class, 1);
        Assert.assertNotNull(product);
        System.out.println("It only performs a query when a property is used.");
        Assert.assertEquals("Apple Watch Series 5", product.getName());
    }

    @Test
    public void mustDiscardChanges(){
        Product product = entityManager.find(Product.class, 1);
        product.setName("Iphone X");

        //Restore entity
        entityManager.refresh(product);

        Assert.assertEquals("Apple Watch Series 5", product.getName());
    }
}
