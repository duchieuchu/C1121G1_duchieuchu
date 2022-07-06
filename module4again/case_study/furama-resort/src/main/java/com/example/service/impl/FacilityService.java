package com.example.service.impl;

import com.example.model.faciltity.Facility;
import com.example.repository.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return this.iFacilityRepository.findAll(pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Facility facility) {
        iFacilityRepository.delete(facility);
    }

    @Override
    public Page<Facility> findAllByName(String name, Pageable pageable) {
        return iFacilityRepository.findAllByNameContaining(name,pageable);
    }
}
