package com.geekbrains.app.model;

import java.math.BigDecimal;

public class Product {
   private Long id;
   private String title;
   private Double cost;

    public Product(Long id, String title, Double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product() {
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
