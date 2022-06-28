package com.example.service.impl;

import com.example.model.BookType;
import com.example.repository.IBookTypeRepository;
import com.example.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService implements IBookTypeService {
    @Autowired
    private IBookTypeRepository iBookTypeRepository;

    @Override
    public List<BookType> findAll() {
        return iBookTypeRepository.findAll();
    }

    @Override
    public BookType findById(Integer id) {
        return iBookTypeRepository.findById(id).orElse(null);
    }
}
