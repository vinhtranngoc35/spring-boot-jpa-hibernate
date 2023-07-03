package com.example.demo.repository;

import com.example.demo.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
}
