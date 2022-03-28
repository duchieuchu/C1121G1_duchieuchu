package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/product?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("SQLState: " + (((SQLException) e).getErrorCode()));
                System.err.println("Message: " + e.getMessage());
                Throwable throwable = ex.getCause();
                while (throwable != null) {
                    System.out.println("Cause" + throwable);
                    throwable = throwable.getCause();
                }
            }
        }
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static final String SELECT_ALL_PRODUCTS = "select * from product;";
    private static final String INSERT_PRODUCT_SQL = "insert into product" + " (product_id,product_name," +
            "product_price,product_quantity,product_color,product_description,product_category) values " + " ( ?, ?,?, ?, ?,?, ?);";
    private static final String DELETE_PRODUCT_SQL = "delete from product where product_id=?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set product_name =?,product_price=?,product_quantity=?," +
            "product_color=?,product_description=?,product_category=? where product_id=?;";

    @Override
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
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
            printSQLException(e);
        }
        return products;
    }

    @Override
    public Product selectProduct(int id) {
        List<Product> products = selectAllProducts();
        Product product = null;
        for (Product product1 : products) {
            if (product1.getId() == id) {
                product = product1;
            }
        }
        return product;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
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
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.setInt(7, product.getId());
            preparedStatement.executeUpdate();
        }
    }
}
