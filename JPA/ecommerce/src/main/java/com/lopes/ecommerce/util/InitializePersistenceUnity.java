package com.lopes.ecommerce.util;

import com.lopes.ecommerce.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InitializePersistenceUnity {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Product product = entityManager.find(Product.class, 1);
        System.out.println(product);

        entityManager.close();
        entityManagerFactory.close();

    }
}
