package ir.resuinventory.model.repository;

import ir.resuinventory.model.entity.Category;
import ir.resuinventory.model.entity.Product;
import ir.resuinventory.model.utils.JPA;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ProductDA implements AutoCloseable {

    private EntityManager entityManager;

//    public Product selectByCode(String code) {
//        entityManager = JPA.getJpa().getEntityManager();
//        Query query = entityManager.createQuery("select oo from Product oo where oo.code =: code");
//        query.setParameter("code", code);
//        return (Product) query.getSingleResult();
//    }

    public Product insertProduct(Product product, long categoryId) {
        entityManager = JPA.getJpa().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Category category = entityManager.find(Category.class, categoryId);
        entityManager.persist(product);
        category.setProduct(product);
        entityManager.merge(category);
        entityTransaction.commit();
        return product;
    }

    public List<Product> selectAllFully() {
        entityManager = JPA.getJpa().getEntityManager();
//        String sql = "select entity from " + Product.class.getName() + " entity ";
        String sql = "SELECT p.PRODUCTID, p.PRODUCTNAME, c.CATEGORYID FROM PRODUCT_TABLE p, CATEGORY_TABLE_PRODUCT_TABLE cp, CATEGORY_TABLE c WHERE cp.PRODUCTS_PRODUCTID = p.PRODUCTID and c.CATEGORYID = cp.CATEGORY_CATEGORYID";
        Query query =
                entityManager
                        .createNativeQuery(sql, "ProductMapping");
        List<Product> pList = query.getResultList();

        for (int j = 0; j < pList.size(); j++) {

            sql = "WITH RECURSIVE (CATEGORYID, CATEGORYNAME, PARENTID) AS (" +
                    "SELECT CATEGORYID, CATEGORYNAME, PARENTID " +
                    "FROM CATEGORY_TABLE " +
                    "WHERE CATEGORYID =:ID " +
                    "UNION ALL " +
                    "SELECT c.CATEGORYID, c.CATEGORYNAME, c.PARENTID " +
                    "FROM CATEGORY_TABLE c " +
                    "JOIN RECURSIVE cp ON c.CATEGORYID = cp.PARENTID" +
                    ")" +
                    "SELECT CATEGORYID, CATEGORYNAME, PARENTID " +
                    "FROM RECURSIVE";

            query =
                    entityManager
                            .createNativeQuery(sql, Category.class);

            query.setParameter("ID", pList.get(j).getCategoryId());
            List<Category> cList = query.getResultList();
            String temp = cList.get(0).getCategoryName();
            Category tCategory;
            for (int i = 1; i < cList.size(); i++) {

                tCategory = cList.get(i);
                if (!tCategory.getCategoryName().equals("root")) {

                    temp += "-" + tCategory.getCategoryName();
                } else {

                    pList.get(j).setCategories(temp);
                }
            }
        }
        return pList;
    }

    public void close() throws Exception {
        entityManager.close();
    }
}
