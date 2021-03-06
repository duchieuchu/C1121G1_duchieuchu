package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(Integer id);
    void update(Integer id, Product product);
    void delete(Integer id);

    List<Product> findByName(String name);
}
