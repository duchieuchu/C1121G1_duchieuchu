package com.example.service;

import com.example.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
