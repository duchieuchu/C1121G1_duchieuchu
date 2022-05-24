package com.example.service.service;


import com.example.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();

    Page<Service> findAll(Pageable pageable);

    void save(Service service);

    void delete(Service service);

}
