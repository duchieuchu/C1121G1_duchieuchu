package com.codegym.dao;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUerDAO {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return this.userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }


    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userRepository.updateUser(user);
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
