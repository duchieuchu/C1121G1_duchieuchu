package repository;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    List<Product> selectAllProduct();

    Product selectProductById(int id);

    void addProduct(Product product) throws SQLException;

    void deleteProduct(int id) throws SQLException;

    void updateProduct(Product product) throws SQLException;
}
