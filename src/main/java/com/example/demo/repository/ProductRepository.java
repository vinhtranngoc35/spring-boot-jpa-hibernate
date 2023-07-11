package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE " +
            "(p.code like :search or " +
            "p.title like :search or " +
            "p.category.name like :search) and " +
            "p.price between :min and :max")
    Page<Product> searchEverything(String search,BigDecimal min, BigDecimal max, Pageable pageable);



    Page<Product> findByTitleContainingOrCodeContainingOrCategory_NameContainingAndPriceBetween(String title, String code, String category_name, BigDecimal price, BigDecimal price2, Pageable pageable);
}
