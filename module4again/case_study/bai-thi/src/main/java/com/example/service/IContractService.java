package com.example.service;

import com.example.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    void save(Contract contract);
    Contract findById(Integer id);
    void delete(Contract contract);

    Page<Contract>findAllByName(String name,Pageable pageable);
    List<Contract> findAll();

}
