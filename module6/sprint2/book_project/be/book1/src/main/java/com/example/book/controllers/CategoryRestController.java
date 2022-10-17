package com.example.book.controllers;

import com.example.book.models.Book;
import com.example.book.models.Category;
import com.example.book.service.IBookService;
import com.example.book.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;


    @GetMapping("/getAllCategory")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Category>> getAllCategory() {

        List<Category> categoryList = this.iCategoryService.getAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(categoryList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }
}
