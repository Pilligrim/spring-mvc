package com.geekbrains.app.service;

import com.geekbrains.app.model.Product;
import com.geekbrains.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "prototype")
public class CartService {
    private List<Product> products;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Long id) {
        products.add(productRepository.getProduct(id));
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.getProduct(id);
        products.remove(product);
    }
}
