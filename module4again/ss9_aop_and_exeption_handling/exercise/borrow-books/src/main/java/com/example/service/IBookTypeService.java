package com.example.service;

import com.example.model.BookType;

import java.util.List;

public interface IBookTypeService {
    List<BookType>findAll();
    BookType findById(Integer id);
}
