package com.lopes.ecommerce.test.training.relationships;

import com.lopes.ecommerce.model.*;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class RelationshipManyToManyTest extends AbstractApplicationTest {

    @Test
    public void mustTestRelationshipManyToMany(){

        Product product = entityManager.find(Product.class, 1);
        Category category = entityManager.find(Category.class, 1);

        Assert.assertNotNull(product);
        Assert.assertNotNull(category);

        entityManager.getTransaction().begin();
        product.setCategories(Collections.singletonList(category));
        entityManager.persist(category);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category categoryVerified = entityManager.find(Category.class,category.getId());
        Assert.assertFalse(categoryVerified.getProducts().isEmpty());
    }

}
