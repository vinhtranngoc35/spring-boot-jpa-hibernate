package com.example.demo.service.product;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.product.request.ProductSaveRequest;
import com.example.demo.service.product.response.ProductListResponse;
import com.example.demo.ulti.AppUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductListResponse> findAllWithSearchAndPaging(String search, Pageable pageable){
//        Page<Product> products = productRepository
//                .findByTitleContainingOrCodeContainingOrCategory_NameContaining(search, search,search,pageable);
//
//        List<ProductListResponse> productListResponses = new ArrayList<>();
//
//        for (var product : products) {
//            ProductListResponse response = AppUtils.mapper.map(product, ProductListResponse.class);
//            productListResponses.add(response);
//        }
//        Page<ProductListResponse> responsePage = new PageImpl<>(productListResponses, pageable, products.getTotalPages());

        // di qua cac phan tu xong map tu product qua productlistresponse.
//        return productRepository
//                .findByTitleContainingOrCodeContainingOrCategory_NameContaining(search, search,search,pageable)
//                .map(product -> new ProductListResponse(product.getId(), product.getTitle(), product.getCode(), product.getPrice(), product.getCategory().getName()));
        return productRepository
                .findByTitleContainingOrCodeContainingOrCategory_NameContaining(search, search,search,pageable)
                .map(product -> {
                    var response = AppUtils.mapper.map(product, ProductListResponse.class);
                    response.setCategoryName(product.getCategory().getName());
                    return response;
                });
    }

    public void create(ProductSaveRequest request){

        Product newProduct = AppUtils.mapper.map(request, Product.class);
        //newProduct.setCategory(new Category(Long.valueOf(request.getCategoryId())));
        productRepository.save(newProduct);
    }
    public void update(ProductSaveRequest request, Long id){
        Product newProduct = AppUtils.mapper.map(request, Product.class);
        newProduct.setId(id);

        //newProduct.setCategory(new Category(Long.valueOf(request.getCategoryId())));
        productRepository.save(newProduct);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
