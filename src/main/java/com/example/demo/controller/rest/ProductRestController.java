package com.example.demo.controller.rest;

import com.example.demo.service.product.ProductService;
import com.example.demo.service.product.request.ProductSaveRequest;
import com.example.demo.service.product.response.ProductListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController // Tạo Api Controller
@RequestMapping("/api/products")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductListResponse> findAll(@RequestParam(defaultValue = "") String search, Pageable pageable){
        return productService.findAllWithSearchAndPaging(search, pageable);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductSaveRequest request){
        productService.create(request);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ProductSaveRequest request, @PathVariable Long id){
        productService.update(request, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
