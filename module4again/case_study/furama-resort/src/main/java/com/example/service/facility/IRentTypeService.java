package com.example.service.facility;

import com.example.model.faciltity.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType>findAll();
    RentType findById(Integer id);
}
