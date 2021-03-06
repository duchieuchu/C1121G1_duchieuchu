package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    void update(Integer id, Product product);

    Product findById(int id);
    void remove(Integer id);

    List<Product> findByName(String name);
}
