package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.product.request.ProductSaveRequest;
import com.example.demo.service.product.request.SelectOptionRequest;
import com.example.demo.service.product.response.ProductListResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView view = new ModelAndView("/products/create");
        view.addObject("categories", categoryRepository.findAll());
        view.addObject("product", new ProductSaveRequest("", "", new SelectOptionRequest("")));
        return view;
    }

    @PostMapping("/create")
    public String showFormCreate(@ModelAttribute("product") ProductSaveRequest product, Model model){
       productService.create(product);

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("product", product);
        return "/products/create";
    }

//    @PostMapping("/edit/{id}")
//    public String showFormCreate(@ModelAttribute("product") ProductSaveRequest product, Model model){
//        productService.update(product);
//
//        model.addAttribute("categories", categoryRepository.findAll());
//        model.addAttribute("product", product);
//        return "create";
//    }

    @GetMapping
    public String createProduct(@RequestParam(defaultValue = "") String search, @PageableDefault(size = 3) Pageable pageable, Model model,
                                @CookieValue(defaultValue = "", value = "demo") String demo,
                                HttpServletResponse response,
                                HttpServletRequest request){
        Cookie cookie = new Cookie("demo", "Hello");
        response.addCookie(cookie);
        cookie.setMaxAge(24 * 60 * 60);
        var cookies = request.getCookies();
        for (var item : cookies) {
            System.out.println(item.getValue());
        }
        //model.addAttribute("products", productService.findAllWithSearchAndPaging(search, "", "", pageable));
        return "index";
    }
//    @GetMapping
//    public String showProducts(Model model) {
//        model.addAttribute("products", productRepository.findAll());
//        return "index";
//    }
}
