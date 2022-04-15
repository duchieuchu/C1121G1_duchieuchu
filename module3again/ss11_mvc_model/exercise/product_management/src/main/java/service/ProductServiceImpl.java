package service;

import model.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository= new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }
}
