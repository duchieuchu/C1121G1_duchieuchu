package com.example.service.contract.impl;

import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IContractDetailRepository;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return iContractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        iContractDetailRepository.delete(contractDetail);
    }

}
