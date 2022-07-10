package com.example.service.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract>findAll(Pageable pageable);
    void save(Contract contract);
    Contract findById(Integer id);
    void delete(Contract contract);
}
