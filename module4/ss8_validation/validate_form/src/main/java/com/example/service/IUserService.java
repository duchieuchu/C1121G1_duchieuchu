package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    User findById(Integer id);

    void update(User user);

    List<User> findByName(String name);

    void remove(User user);

    Page<User> findAll(Pageable pageable);

    Page<User> getUserByName(String name, Pageable pageable);
}
