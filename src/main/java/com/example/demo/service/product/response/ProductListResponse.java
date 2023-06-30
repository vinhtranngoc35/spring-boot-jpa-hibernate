package com.example.demo.service.product.response;

import java.math.BigDecimal;

public class ProductListResponse {
    Long id;
    String title;
    String code;
    BigDecimal price;
    String categoryName;

    public ProductListResponse(Long id, String title, String code, BigDecimal price, String categoryName) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.price = price;
        this.categoryName = categoryName;
    }

    public ProductListResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
