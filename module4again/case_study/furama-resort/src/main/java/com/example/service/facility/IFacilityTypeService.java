package com.example.service.facility;

import com.example.model.faciltity.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType>findAll();
    FacilityType findById(Integer id);
}
