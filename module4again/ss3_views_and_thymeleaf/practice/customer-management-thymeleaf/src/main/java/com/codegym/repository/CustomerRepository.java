package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void add(Customer customer) {
        int id = (int) (Math.random() * 100);
        customer.setId(id);
        customers.put(customer.getId(), customer);
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    @Override
    public Customer findById(Integer id) {
        return customers.get(id);
    }

    @Override
    public void update(Integer id, Customer customer) {
        customers.put(id, customer);
    }
}
