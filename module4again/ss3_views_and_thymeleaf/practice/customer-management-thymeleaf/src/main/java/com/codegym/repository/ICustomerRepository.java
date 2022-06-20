package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer>findAll();
    void add(Customer customer);
    void delete(Integer id);

    Customer findById(Integer id);
    void update(Integer id,Customer customer);
}
