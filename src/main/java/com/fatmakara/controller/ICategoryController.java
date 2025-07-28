package com.fatmakara.controller;

import com.fatmakara.entities.Category;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICategoryController {
  Category saveCategory(Category category);
  List<Category> getAllCategory();
  Category getCategoryById(Integer id);
  public void deleteCategory(Integer id);
  public Category updateCategory(Integer id, Category updateCategory);

    }