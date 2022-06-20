package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public void add(Customer customer) {
        this.iCustomerRepository.add(customer);
    }

    @Override
    public void delete(Integer id) {
        this.iCustomerRepository.delete(id);
    }

    @Override
    public Customer findById(Integer id) {
        return this.iCustomerRepository.findById(id);
    }

    @Override
    public void update(Integer id, Customer customer) {
        this.iCustomerRepository.update(id,customer);
    }
}
