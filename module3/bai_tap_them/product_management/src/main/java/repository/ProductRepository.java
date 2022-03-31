package repository;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_PRODUCT = "select * from product;";


    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("product_price");
                int quantity = resultSet.getInt("product_quantity");
                String color = resultSet.getString("product_color");
                String description = resultSet.getString("product_description");
                String category = resultSet.getString("product_category");
                products.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product selectProductById(int id) {
        return null;
    }

    @Override
    public void addProduct(Product product) throws SQLException {

    }

    @Override
    public void deleteProduct(int id) throws SQLException {

    }

    @Override
    public void updateProduct(Product product) throws SQLException {

    }
}
