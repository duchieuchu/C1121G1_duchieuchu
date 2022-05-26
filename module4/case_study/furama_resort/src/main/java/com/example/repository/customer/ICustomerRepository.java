package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    @Query(value="select * from customer where name like :name or address like :name or code like :name",nativeQuery=true)
    Page<Customer>searchAll(@Param("name") String name, Pageable pageable);

    Page<Customer>findAllByNameContainingOrAddressContainingOrCodeContaining(String name, String address, String code, Pageable pageable);
}
