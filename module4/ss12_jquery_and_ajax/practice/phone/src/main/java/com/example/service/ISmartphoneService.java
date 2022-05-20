package com.example.service;

import com.example.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISmartphoneService {
    Page<Smartphone> findAll(Pageable pageable);

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartphone);

    void remove(Smartphone smartphone);
}
