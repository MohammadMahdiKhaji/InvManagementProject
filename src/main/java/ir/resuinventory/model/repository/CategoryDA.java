package ir.resuinventory.model.repository;

import jakarta.persistence.EntityManager;

public class CategoryDA implements AutoCloseable {

    private EntityManager entityManager;





    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
