package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.ProductImport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImportRepository extends JpaRepository<ProductImport, Long> {
}
