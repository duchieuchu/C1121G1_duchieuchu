package com.example.repository.facility;

import com.example.model.faciltity.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility>findAllByNameContaining(String name, Pageable pageable);
}
