package repository;

import model.HocSinh;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HocSinhRepository implements IHocSinhRepository {
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

    private static final String SELECT_ALL_HOCSINH = "select * from hoc_sinh";
    private static final String SELECT_HOCSINH_BY_ID = "select ma_hoc_sinh,ten_hoc_sinh,lop from hoc_sinh where id_hoc_sinh=?;";

    @Override
    public List<HocSinh> selectAllHocSinh() {
        List<HocSinh> hocSinhs = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOCSINH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idHocSinh = resultSet.getInt("id_hoc_sinh");
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                String tenHocSinh = resultSet.getString("ten_hoc_sinh");
                String lop = resultSet.getString("lop");
                hocSinhs.add(new HocSinh(idHocSinh, maHocSinh, tenHocSinh, lop));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocSinhs;
    }

    @Override
    public HocSinh selectHocSinh(int idHocSinh) {
        HocSinh hocSinh = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOCSINH_BY_ID)) {
            preparedStatement.setInt(1, idHocSinh);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                String tenHocsinh = resultSet.getString("ten_hoc_sinh");
                String lop = resultSet.getString("lop");
                hocSinh = new HocSinh(idHocSinh, maHocSinh, tenHocsinh, lop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocSinh;
    }
}
