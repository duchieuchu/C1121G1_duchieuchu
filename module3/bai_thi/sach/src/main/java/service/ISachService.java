package service;

import model.Sach;

import java.sql.SQLException;
import java.util.List;

public interface ISachService {
    List<Sach> selectAllBook();

    Sach selectBook(int id);

    void insertBook(Sach sach) throws SQLException;

    boolean deleteBook(int id) throws SQLException;

    void updateBook(Sach sach) throws SQLException;
}
