package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select s from product1 s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void update(Integer id, Product product) {

    }

    @Override
    public Product findById(Integer id) {
        return null;
    }
}
