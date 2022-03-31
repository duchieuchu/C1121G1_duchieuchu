package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> selectAllProduct() {
        return productRepository.selectAllProduct();
    }

    @Override
    public Product selectProductById(int id) {
        return productRepository.selectProductById(id);
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        productRepository.addProduct(product);
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        productRepository.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productRepository.updateProduct(product);
    }
}
