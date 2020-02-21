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
}
