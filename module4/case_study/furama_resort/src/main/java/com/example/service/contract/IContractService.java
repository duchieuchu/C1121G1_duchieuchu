package com.example.service.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(Contract contract);
}
