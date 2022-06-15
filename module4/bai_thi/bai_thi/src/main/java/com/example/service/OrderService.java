package com.example.service;

import com.example.model.Order;
import com.example.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return iOrderRepository.findAll(pageable);
    }

}
