package com.fatmakara.controller.impl;

import com.fatmakara.controller.ICategoryController;
import com.fatmakara.entities.Category;
import com.fatmakara.services.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/category")
@CrossOrigin(origins = "http://localhost:4200")  // CORS için çok önemli


public class CategoryControllerImpl implements ICategoryController {
    private final ICategoryService categoryService;
    public CategoryControllerImpl(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Override
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
    @Override
    @GetMapping("/list")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }
    @GetMapping(path = "/list/{id}")
    @Override
    public Category getCategoryById(@PathVariable(name="id") Integer id) {
        return categoryService.getCategoryById(id);
    }
    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteCategory(@PathVariable(name = "id") Integer id) {
        categoryService.deleteCategory(id);
    }
    @PutMapping(path = "/update/{id}")
    @Override
    public Category updateCategory(@PathVariable("id")Integer id,@RequestBody Category updateCategory) {
        return categoryService.updateCategory(id, updateCategory);
    }
}