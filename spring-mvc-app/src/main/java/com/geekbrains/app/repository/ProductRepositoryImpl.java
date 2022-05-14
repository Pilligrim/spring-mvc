package com.geekbrains.app.repository;

import com.geekbrains.app.model.Product;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Primary
@NoArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        return entityManager.createQuery("Select a from Product a", Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.merge(product);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.createQuery("delete from Product where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
