package com.example.service;

import com.example.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Page<Order> findAll(Pageable pageable);
}
