package com.example.dao;

import com.example.model.Login;
import com.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setAccount("join");
        user1.setPassword("123123");
        user1.setName("Join");
        user1.setEmail("join@gmail.com");
        user1.setAge(10);
        users.add(user1);

        User user2 = new User();
        user2.setAccount("kie");
        user2.setPassword("123123");
        user2.setName("Kie");
        user2.setEmail("kie@gmail.com");
        user2.setAge(9);
        users.add(user2);

        User user3 = new User();
        user3.setAccount("chi");
        user3.setPassword("123123");
        user3.setName("chi");
        user3.setEmail("chi@gmail.com");
        user3.setAge(11);
        users.add(user3);
    }

    public static User checkLogin(Login login) {
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount()) &&
                user.getPassword().equals(login.getPassword())) {
                return user;
            }
        } return null;
    }
}
