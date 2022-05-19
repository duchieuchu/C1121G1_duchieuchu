package com.example.service;

import com.example.model.Smartphone;
import com.example.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return this.iSmartphoneRepository.findAll(pageable);
    }

    @Override
    public Smartphone findById(Integer id) {
        return this.iSmartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return this.iSmartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Smartphone smartphone) {
        this.iSmartphoneRepository.delete(smartphone);
    }
}
