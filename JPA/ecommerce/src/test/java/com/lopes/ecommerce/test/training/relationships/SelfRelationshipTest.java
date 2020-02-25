package com.lopes.ecommerce.test.training.relationships;

import com.lopes.ecommerce.model.*;
import com.lopes.ecommerce.test.config.AbstractApplicationTest;
import org.junit.Assert;
import org.junit.Test;

public class SelfRelationshipTest extends AbstractApplicationTest {

    @Test
    public void mustVerifyRelationship() {

        Category categoryOwner = new Category();
        categoryOwner.setName("Electronics");

        Category category = new Category();
        category.setName("Smartphone");
        category.setOwnerCategory(categoryOwner);

        entityManager.getTransaction().begin();
        entityManager.persist(categoryOwner);
        entityManager.persist(category);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category categoryVerified = entityManager.find(Category.class, category.getId());
        Assert.assertNotNull(categoryVerified.getOwnerCategory());

    }

    @Test
    public void mustVerifyInverseRelationship() {

        Category categoryOwner = new Category();
        categoryOwner.setName("Electronics");

        Category category = new Category();
        category.setName("Smartphone");
        category.setOwnerCategory(categoryOwner);

        entityManager.getTransaction().begin();
        entityManager.persist(categoryOwner);
        entityManager.persist(category);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category categoryOwnerVerified = entityManager.find(Category.class, categoryOwner.getId());
        Assert.assertFalse(categoryOwnerVerified.getCategories().isEmpty());

    }

}
