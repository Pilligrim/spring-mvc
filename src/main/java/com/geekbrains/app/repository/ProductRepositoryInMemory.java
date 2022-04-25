package com.geekbrains.app.repository;

import com.geekbrains.app.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryInMemory implements ProductRepository {
    private List<Product> products;
    private Long maxId;

    public ProductRepositoryInMemory() {
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product((long) i, "Product" + i, i * 100));
        }
        maxId = Long.valueOf(products.size());
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> id.equals(p.getId())).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        product.setId(++maxId);
        products.add(product);
    }

    @Override
    public void delete(Long id) {
        products.removeIf(p -> id.equals(p.getId()));
    }

}
