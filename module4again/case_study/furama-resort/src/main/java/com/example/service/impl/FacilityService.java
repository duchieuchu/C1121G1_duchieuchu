package com.example.service.impl;

import com.example.model.faciltity.Facility;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityService iFacilityService;
    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityService.findAll(pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityService.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return iFacilityService.findById(id);
    }

    @Override
    public void delete(Facility facility) {
        iFacilityService.delete(facility);
    }

    @Override
    public Page<Facility> findAllByName(String name, Pageable pageable) {
        return iFacilityService.findAllByName(name,pageable);
    }
}
