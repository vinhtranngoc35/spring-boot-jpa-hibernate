package com.example.demo.controller;

import com.example.demo.model.enums.Color;
import com.example.demo.model.enums.Size;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product-imports")
@AllArgsConstructor
public class ProductImportController {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    @GetMapping
    public ModelAndView showCreateForm(){
        ModelAndView view = new ModelAndView("/product-import/list");
        view.addObject("customers", customerRepository.findAll());
        view.addObject("products", productRepository.findAll());
        view.addObject("sizes", Size.values());
        view.addObject("colors", Color.values());
        return view;
    }

}
