package com.itransition.itransitionproject.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EMF implements ServletContextListener {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

    @Override
    public void contextInitialized(ServletContextEvent event) {
        emf = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        return emf.createEntityManager();
    }
}