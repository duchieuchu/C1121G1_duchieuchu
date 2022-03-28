package repository;

import model.HocSinh;
import model.Sach;
import model.TheMuonSach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachRepository implements ITheMuonSachRepository {
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

    private static final String SELECT_ALL_THE_MUON_SACH = "select * from the_muon_sach";
    private static final String SELECT_THE_MUON_SACH_BY_ID = "select ma_muon_sach,ma_sach,ma_hoc_sinh,trang_thai,ngay_muon,ngay_tra,ngay_tra,id_sach from hoc_sinh where id_muon_sach=?;";

    @Override
    public List<TheMuonSach> selectAllTheMuonSach() {
        List<TheMuonSach> theMuonSachs = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THE_MUON_SACH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTheMuonSach = resultSet.getInt("id_muon_sach");
                String maMuonSach = resultSet.getString("ma_muon_sach");
                String maSach = resultSet.getString("ma_sach");
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                boolean trangThai = resultSet.getBoolean("trang_thai");
                String ngayMuon = resultSet.getString("ngay_muon");
                String ngayTra = resultSet.getString("ngay_tra");
                int idHocSinh = resultSet.getInt("id_hoc_sinh");
                int idSach = resultSet.getInt("id_sach");
                theMuonSachs.add(new TheMuonSach(idTheMuonSach, maMuonSach, maSach, maHocSinh, trangThai, ngayMuon, ngayTra, idHocSinh, idSach));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theMuonSachs;
    }

    @Override
    public TheMuonSach selectTheMuonSach(int idTheMuonSach) {
        TheMuonSach theMuonSach = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THE_MUON_SACH_BY_ID)) {
            preparedStatement.setInt(1, idTheMuonSach);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMuonSach = resultSet.getString("ma_muon_sach");
                String maSach = resultSet.getString("ma_sach");
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                boolean trangThai = resultSet.getBoolean("trang_thai");
                String ngayMuon = resultSet.getString("ngay_muon");
                String ngayTra = resultSet.getString("ngay_tra");
                int idHocSinh = resultSet.getInt("id_hoc_sinh");
                int idSach = resultSet.getInt("id_sach");
                theMuonSach = new TheMuonSach(idTheMuonSach, maMuonSach, maSach, maHocSinh, trangThai, ngayMuon, ngayTra, idHocSinh, idSach);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theMuonSach;
    }
}
