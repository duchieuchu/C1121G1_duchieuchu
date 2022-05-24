package com.example.service.service.impl;

import com.example.repository.service.IServiceRepository;
import com.example.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository iServiceRepository;


    @Override
    public Page<com.example.model.service.Service> findAll(Pageable pageable) {
        return this.iServiceRepository.findAll(pageable);
    }

    @Override
    public void save(com.example.model.service.Service service) {
        this.iServiceRepository.save(service);
    }

    @Override
    public void delete(com.example.model.service.Service service) {
        this.iServiceRepository.delete(service);
    }
}
