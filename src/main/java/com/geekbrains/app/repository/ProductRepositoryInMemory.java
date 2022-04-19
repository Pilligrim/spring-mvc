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
    private Long maxId;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product((long) i, "Product" + i, new BigDecimal(i * 100)));
        }
        maxId = Long.valueOf(products.size());
    }

    public ProductRepositoryInMemory() { }

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

}
