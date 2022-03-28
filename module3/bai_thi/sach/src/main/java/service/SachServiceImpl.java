package service;

import model.Sach;
import repository.ISachRepository;
import repository.SachRepository;

import java.sql.SQLException;
import java.util.List;

public class SachServiceImpl implements ISachService {
    private final ISachRepository sachRepository = new SachRepository();

    @Override
    public List<Sach> selectAllBook() {
        return this.sachRepository.selectAllBook();
    }

    @Override
    public Sach selectBook(int id) {
        return this.sachRepository.selectBook(id);
    }

    @Override
    public void insertBook(Sach sach) throws SQLException {
        sachRepository.insertBook(sach);
    }

    @Override
    public boolean deleteBook(int id) throws SQLException {
        return this.sachRepository.deleteBook(id);
    }

    @Override
    public void updateBook(Sach sach) throws SQLException {

    }
}
