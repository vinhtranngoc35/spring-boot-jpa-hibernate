package com.example.demo.controller.rest;

import com.example.demo.service.product.request.ProductSaveRequest;
import com.example.demo.service.productimport.ProductImportService;
import com.example.demo.service.productimport.request.ProductImportSaveRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product-imports")
public class ProductImportRestController {
    private final ProductImportService productImportService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductImportSaveRequest request){
        productImportService.create(request);
        return ResponseEntity.noContent().build();
    }
}
