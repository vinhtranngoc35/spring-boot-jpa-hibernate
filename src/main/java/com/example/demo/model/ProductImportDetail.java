package com.example.demo.model;

import com.example.demo.model.enums.Color;
import com.example.demo.model.enums.Size;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductImportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Size size;

    private int quantity;

    private int sellQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_import_id")
     ProductImport productImport;

    public ProductImportDetail() {
    }
}
