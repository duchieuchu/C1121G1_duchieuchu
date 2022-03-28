package repository;

import model.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachRepository implements ISachRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/sach1?allowPublicKeyRetrieval=true&useSSL=FALSE";
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

    private static final String SELECT_ALL_BOOKS = "select * from sach;";
    private static final String INSERT__SQL = "insert into product" + " (product_id,product_name," +
            "product_price,product_quantity,product_color,product_description,product_category) values " + " ( ?, ?,?, ?, ?,?, ?);";
    private static final String DELETE_PRODUCT_SQL = "delete from product where product_id=?;";
    private static final String UPDATE_PRODUCT_SQL = "update product set product_name =?,product_price=?,product_quantity=?," +
            "product_color=?,product_description=?,product_category=? where product_id=?;";

    @Override
    public List<Sach> selectAllBook() {
        List<Sach> saches = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_sach");
                String ma = resultSet.getString("ma_sach");
                String ten = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                saches.add(new Sach(id, ma, ten, tacGia, moTa, soLuong));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return saches;
    }

    @Override
    public Sach selectBook(int id) {
        List<Sach> saches = selectAllBook();
        Sach sach = null;
        for (Sach sach1 : saches) {
            if (sach1.getIdSach() == id) {
                sach = sach1;
            }
        }
        return sach;
    }

    @Override
    public void insertBook(Sach sach) throws SQLException {

    }

    @Override
    public boolean deleteBook(int id) throws SQLException {
        return false;
    }

    @Override
    public void updateBook(Sach sach) throws SQLException {

    }
}
