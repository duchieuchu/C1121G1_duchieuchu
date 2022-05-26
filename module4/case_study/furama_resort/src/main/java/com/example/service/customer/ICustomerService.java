package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> getCustomerByName(String name,Pageable pageable);

    Page<Customer> getCustomerByInformation(String name,Pageable pageable);

    void save(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    Customer findById(Integer id);
}
