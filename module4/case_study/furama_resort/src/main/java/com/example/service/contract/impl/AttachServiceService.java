package com.example.service.contract.impl;

import com.example.model.contract.AttachService;
import com.example.repository.contract.IAttachRepository;
import com.example.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachRepository iAttachRepository;
    @Override
    public List<AttachService> findAll() {
        return this.iAttachRepository.findAll();
    }

    @Override
    public AttachService findById(Integer id) {
        return this.iAttachRepository.findById(id).orElse(null);
    }
}
