package repository;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    List<Product> selectAllProducts();

    Product selectProduct(int id);

    void insertProduct(Product product) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    void updateProduct(Product product) throws SQLException;
}
