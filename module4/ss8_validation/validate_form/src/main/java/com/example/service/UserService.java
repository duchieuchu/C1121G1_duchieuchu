package com.example.service;

import com.example.model.User;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        this.iUserRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return this.iUserRepository.findById(id).orElse(null);
    }

    @Override
    public void update(User user) {
        this.iUserRepository.save(user);
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public void remove(User user) {
        this.iUserRepository.delete(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return this.iUserRepository.findAll(pageable);
    }

    @Override
    public Page<User> getUserByName(String name, Pageable pageable) {
        return null;
    }
}
