package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "giay", 20.0, "red color", "vietnam"));
        products.put(2, new Product(2, "kiem", 20.0, "red color", "China"));
        products.put(3, new Product(3, "ao", 20.0, "red color", "China"));
        products.put(4, new Product(4, "mu", 20.0, "red color", "China"));
        products.put(5, new Product(5, "quan", 20.0, "red color", "China"));
        products.put(6, new Product(6, "balo", 20.0, "red color", "China"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        int id = (int) (Math.random() * 100);
        product.setId(id);
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = findAll();
        List<Product> searchList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                searchList.add(productList.get(i));
            }
        }
        return searchList;
    }
}
