package com.example.service.impl;

import com.example.model.faciltity.RentType;
import com.example.repository.IRentTypeRepository;
import com.example.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return iRentTypeRepository.findById(id).orElse(null);
    }
}
