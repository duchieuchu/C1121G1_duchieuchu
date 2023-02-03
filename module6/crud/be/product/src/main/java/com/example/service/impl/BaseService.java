package com.example.service.impl;

import com.example.model.Base;
import com.example.repository.IBaseRepository;
import com.example.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService implements IBaseService {
    @Autowired
    private IBaseRepository iBaseRepository;

    @Override
    public void deleteBase(Integer id) {
        iBaseRepository.deleteProduct(id);
    }

    @Override
    public List<Base> getAllBase1() {
        return iBaseRepository.getList();
    }

    @Override
    public List<Base> searchBase(String name) {
        return iBaseRepository.searchList("%" + name + "%");
    }

    @Override
    public void createBase(Base base) {
        iBaseRepository.createBase(base);
    }

}
