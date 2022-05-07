package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "giay", 20.0, "red", "adidas"));
        productMap.put(2, new Product(2, "giay1", 20.0, "red", "safa"));
        productMap.put(3, new Product(3, "giay2", 20.0, "red", "asd"));
        productMap.put(4, new Product(4, "giay3", 20.0, "red", "asdasd"));
        productMap.put(5, new Product(5, "giay4", 20.0, "red", "sadvsda"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        int id = (int) (Math.random() * 100);
        product.setId(id);
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }
}
