package ir.resuinventory.model.service;

import ir.resuinventory.model.entity.Category;
import ir.resuinventory.model.entity.Product;
import ir.resuinventory.model.repository.CRUDRepository;
import ir.resuinventory.model.repository.ProductDA;
import ir.resuinventory.model.service.generic.Service;
import ir.resuinventory.model.utils.JPA;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProductService extends Service<Product, Long> {

    private static ProductService productService = new ProductService();

    private ProductService(){
    }

    public static ProductService getProductService() {
        return productService;
    }

    public Product insert(Product product) throws Exception {
        try(CRUDRepository<Product,Long> repository = new CRUDRepository<>()){
            return repository.insert(product);
        }
    }

    public Product update(Product product) throws Exception {
        try(CRUDRepository<Product,Long> repository = new CRUDRepository<>()){
            return repository.update(product);
        }
    }

    public Product delete(Long aLong) throws Exception {
        try(CRUDRepository<Product,Long> repository = new CRUDRepository<>()){
            return repository.delete(Product.class, aLong);
        }
    }

    public List<Product> selectAll() throws Exception {
        try(CRUDRepository<Product,Long> repository = new CRUDRepository<>()){
            return repository.selectAll(Product.class);
        }
    }

    public Product selectById(Long aLong) throws Exception {
        try(CRUDRepository<Product,Long> repository = new CRUDRepository<>()){
            return repository.selectById(Product.class, aLong);
        }
    }

//    public Product selectByCode(String code) throws Exception {
//        try(ProductDA repository = new ProductDA()) {
//            return repository.selectByCode(code);
//        }
//    }

    public Product insertProduct(Product product, long categoryId) throws Exception {
        try(ProductDA repository = new ProductDA()) {
            return repository.insertProduct(product, categoryId);
        }
    }
    public List<Product> selectAllFully() throws Exception {
        try(ProductDA repository = new ProductDA()) {
            return repository.selectAllFully();
        }
    }
}
