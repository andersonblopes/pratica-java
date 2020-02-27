package com.lopes.ecommerce.test.training;

import com.lopes.ecommerce.model.Category;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

public class CategoryTest extends AbstractApplicationTest {

    @Test
    public void mustGenerateCategoryId() {
        Category category = new Category();
        category.setName("Smartphone");

        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();

        entityManager.clear();// Clean cache level 1

        Category category1Persisted = entityManager.find(Category.class, category.getId());
        Assert.assertNotNull(category1Persisted);
    }
}
