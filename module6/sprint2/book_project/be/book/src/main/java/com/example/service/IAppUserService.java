package com.example.service;

import com.example.model.AppUser;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;


import java.io.UnsupportedEncodingException;

public interface IAppUserService {
    AppUser findByName(String name);

    String existsByUserName(String username) throws MessagingException,UnsupportedEncodingException ;

    void saveNewPassword(String password, String name);
}
