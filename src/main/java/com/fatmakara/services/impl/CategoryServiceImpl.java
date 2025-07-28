package com.fatmakara.services.impl;
import com.fatmakara.entities.Category;
import com.fatmakara.repository.CategoryRepository;
import com.fatmakara.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    @Override
    public List<Category> getAllCategories() {
        List<Category>categoryList=categoryRepository.findAll();
        return categoryList;
    }
    public Category getCategoryById(Integer id) {
        Optional<Category> optional=categoryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {
          Category dbCategory=getCategoryById(id);
          if (dbCategory != null) {
              categoryRepository.delete(dbCategory);
          }
           //once id si su olan category yi veritabaninda bul sonra sil
    }

    @Override
    public Category updateCategory(Integer id, Category updatecategory) {
        Category dbCategory = getCategoryById(id);
        if (dbCategory != null) {
            // Sadece ismi güncelle
            dbCategory.setName(updatecategory.getName());

            // Fotoğraflara asla dokunma!
            return categoryRepository.save(dbCategory);
        }

        throw new RuntimeException("Kategori bulunamadı. ID: " + id);
    }

}
