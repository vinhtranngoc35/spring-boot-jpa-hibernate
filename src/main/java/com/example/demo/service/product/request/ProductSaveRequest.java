package com.example.demo.service.product.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public class ProductSaveRequest {
    private String price;
    private String title;
    private SelectOptionRequest category;

    public ProductSaveRequest(String price, String title, SelectOptionRequest category) {
        this.price = price;
        this.title = title;
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SelectOptionRequest getCategory() {
        return category;
    }

    public void setCategory(SelectOptionRequest category) {
        this.category = category;
    }
}
