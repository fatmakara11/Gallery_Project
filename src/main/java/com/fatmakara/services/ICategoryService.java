package com.fatmakara.services;

import com.fatmakara.entities.Category;

import java.util.List;

public interface ICategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategoryById(Integer id);
    public void deleteCategory(Integer id);
    public Category updateCategory(Integer id, Category updatecategory);
}
