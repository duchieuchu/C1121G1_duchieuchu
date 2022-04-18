package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    void insertUser(User user) throws SQLException;

    User selectUser(Integer id);

    List<User> selectAllUser();

    void deleteUser(Integer id) throws SQLException;

    void update(User user) throws SQLException;

    List<User> findByCountry(String country);

    List<User> sortByName();
}
