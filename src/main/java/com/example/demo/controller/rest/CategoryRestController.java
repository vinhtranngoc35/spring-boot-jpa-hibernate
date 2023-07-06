package com.example.demo.controller.rest;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryRestController {
    private final CategoryRepository categoryRepository;

    public CategoryRestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
