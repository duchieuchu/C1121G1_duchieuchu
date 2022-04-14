package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save();

    void findById(String id);

    void update(Product product);

    void delete(String id);

}
