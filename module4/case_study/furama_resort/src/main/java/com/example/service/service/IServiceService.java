package com.example.service.service;


import com.example.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    Page<Service> findAll(Pageable pageable);

    void save(Service service);

    void delete(Service service);

}
