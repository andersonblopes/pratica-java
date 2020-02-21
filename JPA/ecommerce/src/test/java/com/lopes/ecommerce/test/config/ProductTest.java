package com.lopes.ecommerce.test.config;

import com.lopes.ecommerce.model.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest extends AbstractApplicationTest{

    @Test
    public void mustFindOneProduct(){
        Product product = entityManager.find(Product.class, 1);
        Assert.assertNotNull(product);
    }

    @Test
    public void mustFindOneProductByReference(){
        Product product = entityManager.getReference(Product.class, 1);
        Assert.assertNotNull(product);
        System.out.println("Just execute query, when one property is used.");
        Assert.assertEquals("Kindle", product.getName());
    }

    @Test
    public void mustDiscardChanges(){
        Product product = entityManager.find(Product.class, 1);
        product.setName("Iphone X");

        //Restore entity
        entityManager.refresh(product);

        Assert.assertEquals("Kindle", product.getName());
    }
}
