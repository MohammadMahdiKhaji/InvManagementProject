package ir.resuinventory.model.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPA {
    private static JPA jpa = new JPA();

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("resuInventory");

    private JPA() {
    }

    public static JPA getJpa() {
        return jpa;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
