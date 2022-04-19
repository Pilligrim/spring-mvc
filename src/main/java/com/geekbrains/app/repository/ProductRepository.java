package com.geekbrains.app.repository;

import com.geekbrains.app.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    Product findById(Long id);
    void save(Product product);
}
