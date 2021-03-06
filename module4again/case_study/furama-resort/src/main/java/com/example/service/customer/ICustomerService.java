package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer>findAll(Pageable pageable);
    void save(Customer customer);
    Customer findById(Integer id);
    void delete(Customer customer);

    Page<Customer>findAllByName(String name,Pageable pageable);
    List<Customer>findAll();
}
