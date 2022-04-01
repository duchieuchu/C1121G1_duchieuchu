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
    private static final String ADD_PRODUCT_SQL = "insert into product (product_id,product_name,product_price,product_quantity,product_color,product_description,product_category) values(?,?,?,?,?,?,?);";
    private static final String DELETE_PRODUCT_SQL = "delete from product where product_id=?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set product_name=?,product_price=?,product_quantity=?,product_color=?,product_description=?,product_category=? where product_id=?;";

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
        List<Product> productList = selectAllProduct();
        Product product = null;
        for (Product product1 : productList) {
            if (product1.getId() == id) {
                product = product1;
            }
        }
        return product;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        try (Connection connection = baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT_SQL)) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setString(7, product.getCategory());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        try (Connection connection = baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try (Connection connection = baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.setInt(7,product.getId());
            preparedStatement.executeUpdate();
        }
    }
}
