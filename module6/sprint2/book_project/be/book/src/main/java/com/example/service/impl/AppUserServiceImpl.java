package com.example.service.impl;

import com.example.model.AppUser;
import com.example.service.IAppUserService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.io.UnsupportedEncodingException;

public class AppUserServiceImpl implements IAppUserService {
    @Override
    public AppUser findByName(String name) {
        return null;
    }

    @Override
    public String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException {
        return null;
    }

    @Override
    public void saveNewPassword(String password, String name) {

    }
}
