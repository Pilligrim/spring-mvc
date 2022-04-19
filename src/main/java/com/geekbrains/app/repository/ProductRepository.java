package com.geekbrains.app.repository;

import com.geekbrains.app.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProduct(Long id);
}
