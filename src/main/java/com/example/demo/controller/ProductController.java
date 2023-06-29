package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/data")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{search}")
    public List<Product> createProduct(@PathVariable String search){
        // save category id =
        return productRepository.findByTitleContainingOrCodeContainingOrCategory_NameContaining(search, search,search);
    }
//    @GetMapping
//    public String showProducts(Model model) {
//        model.addAttribute("products", productRepository.findAll());
//        return "index";
//    }
}
