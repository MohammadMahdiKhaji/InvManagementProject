package ir.resuinventory.model.repository;

import ir.resuinventory.model.entity.User;
import ir.resuinventory.model.utils.JPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class UserDA implements AutoCloseable {

    private EntityManager entityManager;

    public User selectByEmail(String email) {
        entityManager = JPA.getJpa().getEntityManager();
        Query query = entityManager.createQuery("select oo from User oo where oo.email =: email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

    public String userExists(User user) {
        entityManager = JPA.getJpa().getEntityManager();
        Query query = entityManager.createQuery("select count(oo.username) from User oo where oo.username =: username");
        query.setParameter("username", user.getUsername());
        Long usernameCount = (Long) query.getSingleResult();
        query = entityManager.createQuery("select count(oo.password) from User oo where oo.password =: password");
        query.setParameter("password", user.getPassword());
        Long passwordCount = (Long) query.getSingleResult();

        if (usernameCount == 0) {
            if (passwordCount == 0) {
                //A user with such info doesn't exist
                return "false";
            }
            return "password";
        } else {
            if (passwordCount != 0) {
                return "username-password";
            }
            return "username";
        }
    }

    public boolean activeUserEmail(String userPassword) {
        entityManager = JPA.getJpa().getEntityManager();
        Query query = entityManager.createQuery("SELECT oo from User oo where oo.password = :password");
        query.setParameter("password", userPassword);
        User user = (User) query.getSingleResult();
        if (!user.isEmailActive()) {

            user.setEmailActive(true);
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(user);
            entityTransaction.commit();
            return true;
        }
        return false;
    }

    public void close() throws Exception {
        entityManager.close();
    }
}
