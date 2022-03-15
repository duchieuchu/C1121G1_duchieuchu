package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;


public class ProductServiceImpl implements ProductService {
    private IProductRepository productRepository=new ProductRepository();

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

}
