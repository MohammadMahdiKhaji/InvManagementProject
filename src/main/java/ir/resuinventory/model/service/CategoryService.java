package ir.resuinventory.model.service;

import ir.resuinventory.model.entity.Category;
import ir.resuinventory.model.entity.Category;
import ir.resuinventory.model.repository.CRUDRepository;
import ir.resuinventory.model.repository.ProductDA;
import ir.resuinventory.model.service.generic.Service;

import java.util.List;

public class CategoryService extends Service<Category, Long> {

    private static CategoryService categoryService = new CategoryService();

    private CategoryService(){
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }

    public Category insert(Category category) throws Exception {
        try(CRUDRepository<Category,Long> repository = new CRUDRepository<>()){
            return repository.insert(category);
        }
    }

    public Category update(Category category) throws Exception {
        try(CRUDRepository<Category,Long> repository = new CRUDRepository<>()){
            return repository.update(category);
        }
    }

    public Category delete(Long aLong) throws Exception {
        try(CRUDRepository<Category,Long> repository = new CRUDRepository<>()){
            return repository.delete(Category.class, aLong);
        }
    }

    public List<Category> selectAll() throws Exception {
        try(CRUDRepository<Category,Long> repository = new CRUDRepository<>()){
            return repository.selectAll(Category.class);
        }
    }

    public Category selectById(Long aLong) throws Exception {
        try(CRUDRepository<Category,Long> repository = new CRUDRepository<>()){
            return repository.selectById(Category.class, aLong);
        }
    }
}
