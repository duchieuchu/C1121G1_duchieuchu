package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void add(Customer customer);
    void delete(Integer id);

    Customer findById(Integer id);
    void update(Integer id,Customer customer);
}
