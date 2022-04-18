package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void insertUser(User user) throws SQLException {
        this.userRepository.insertUser(user);
    }

    @Override
    public User selectUser(Integer id) {
        return this.userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUser() {
        return this.userRepository.selectAllUser();
    }

    @Override
    public void deleteUser(Integer id) throws SQLException {
        this.userRepository.deleteUser(id);
    }

    @Override
    public void update(User user) throws SQLException {
        this.userRepository.update(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return this.userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return this.userRepository.sortByName();
    }
}
