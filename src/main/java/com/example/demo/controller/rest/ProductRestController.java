package com.example.demo.controller.rest;

import com.example.demo.service.EmailService;
import com.example.demo.service.product.ProductService;
import com.example.demo.service.product.request.ProductSaveRequest;
import com.example.demo.service.product.response.ProductListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

//Show List Product
//Viết API trả về List Product
//Viết AJAX call API để trả về Client.


@RestController // Tạo Api Controller
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductRestController {
    private final ProductService productService;

    private final EmailService emailService;

    public ProductRestController(ProductService productService, EmailService emailService) {
        this.productService = productService;
        this.emailService = emailService;
    }

    @GetMapping
    public Page<ProductListResponse> findAll(@RequestParam(defaultValue = "") String search,
                                             @RequestParam(defaultValue = "", required = false) String priceMin,
                                             @RequestParam(defaultValue = "") String priceMax,

                                             Pageable pageable) throws UnknownHostException {
        InetAddress.getLocalHost().getHostAddress();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //emailService.sendEmail("vinhtranngoc35@gmail.com", "Hello", "Demo", false,false);
        return productService.findAllWithSearchAndPaging(search, priceMin, priceMax, pageable);
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
