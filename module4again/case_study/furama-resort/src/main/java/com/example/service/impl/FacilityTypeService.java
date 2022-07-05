package com.example.service.impl;

import com.example.model.faciltity.FacilityType;
import com.example.repository.IFacilityTypeRepository;
import com.example.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(Integer id) {
        return iFacilityTypeRepository.findById(id).orElse(null);
    }
}
