package com.example.service.facility;

import com.example.model.faciltity.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility>findAll(Pageable pageable);
    void save(Facility facility);
    Facility findById(Integer id);
    void delete(Facility facility);
    Page<Facility>findAllByName(String name,Pageable pageable);
}
