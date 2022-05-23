package com.example.service.customer.impl;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> getCustomerByName(String name,Pageable pageable) {
        return this.iCustomerRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.iCustomerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return this.iCustomerRepository.findById(id).orElse(null);
    }
}
