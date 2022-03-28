package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> selectAllProducts() {
        return this.productRepository.selectAllProducts();
    }

    @Override
    public Product selectProduct(int id) {
        return this.productRepository.selectProduct(id);
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        productRepository.insertProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
       return this.productRepository.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productRepository.updateProduct(product);
    }
}
