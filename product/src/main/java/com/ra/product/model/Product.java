package com.ra.product.model;

public class Product {
    private String id;
    private String name;
    private double price;
    private String categoryId;
    private String status;

    public Product() {
    }

    public Product(String id, String name, double price, String categoryId, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
