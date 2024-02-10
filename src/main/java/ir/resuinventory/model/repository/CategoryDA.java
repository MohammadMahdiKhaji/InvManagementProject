package ir.resuinventory.model.repository;

import ir.resuinventory.model.entity.Category;
import ir.resuinventory.model.entity.User;
import ir.resuinventory.model.utils.JPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CategoryDA implements AutoCloseable {

    private EntityManager entityManager;

    public Category selectByName(String name) {
        entityManager = JPA.getJpa().getEntityManager();
        Query query = entityManager.createQuery("SELECT oo FROM Category oo WHERE oo.categoryName =: categoryName");
        query.setParameter("categoryName", name);
        return (Category) query.getSingleResult();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
