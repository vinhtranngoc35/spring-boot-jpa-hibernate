package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE " +
            "p.code like :search or " +
            "p.title like :search or " +
            "p.category.name like :search")
    List<Product> searchEverything(String search);



    List<Product> findByTitleContainingOrCodeContainingOrCategory_NameContaining(String title, String code, String category_name);
}
