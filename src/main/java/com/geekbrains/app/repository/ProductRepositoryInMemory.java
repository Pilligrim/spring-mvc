package com.geekbrains.app.repository;

import com.geekbrains.app.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryInMemory implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product((long) i, "Product" + i, new BigDecimal(i * 100)));
        }
    }

    public ProductRepositoryInMemory() {
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product getProduct(Long id) {
        return products.stream().filter(p->id == p.getId()).findFirst().orElse(null);
    }
}
