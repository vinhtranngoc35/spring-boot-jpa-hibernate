package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.ProductImport;
import com.example.demo.model.ProductImportDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImportDetailRepository extends JpaRepository<ProductImportDetail, Long> {
}
