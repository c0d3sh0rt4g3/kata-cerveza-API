package com.example.katacerveza.controller;

import com.example.katacerveza.exceptions.NotFoundException;
import com.example.katacerveza.model.Category;
import com.example.katacerveza.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    @GetMapping("/categorie/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category", id));
    }
}
