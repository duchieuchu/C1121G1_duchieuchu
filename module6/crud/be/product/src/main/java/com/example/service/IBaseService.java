package com.example.service;

import com.example.model.Base;



import java.util.List;


public interface IBaseService {

    void deleteBase(Integer id);

    List<Base> getAllBase1();
    List<Base> searchBase(String name);

    void createBase(Base base);

}

