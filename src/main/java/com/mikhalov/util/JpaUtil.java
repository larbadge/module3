package com.mikhalov.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Consumer;

public class JpaUtil {
    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static final EntityManagerFactory FACTORY;

    static {
        FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    public static void doWithinTransaction(Consumer<EntityManager> emConsumer) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        emConsumer.accept(manager);
        manager.getTransaction().commit();
        manager.close();
    }

}
