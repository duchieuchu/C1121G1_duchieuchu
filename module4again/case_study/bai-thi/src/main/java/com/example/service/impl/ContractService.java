package com.example.service.impl;

import com.example.model.Contract;
import com.example.repository.IContractRepository;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Contract contract) {
        iContractRepository.delete(contract);
    }

    @Override
    public Page<Contract> findAllByName(String name, Pageable pageable) {
        return iContractRepository.findAllByNameContaining(name,pageable);
    }


    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }
}
