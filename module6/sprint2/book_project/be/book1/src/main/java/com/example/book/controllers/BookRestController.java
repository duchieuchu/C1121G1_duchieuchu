package com.example.book.controllers;

import com.example.book.models.Book;
import com.example.book.service.IBookService;
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

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookRestController {
    @Autowired
    private IBookService iBookService;



    @GetMapping("/getAllPageBookByName")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Page<Book>> getAllPageBookByName(@PageableDefault(9) Pageable pageable,
                                                           Optional<String> bookName) {
        String name = bookName.orElse("");
        if (name.equals("null")) {
            name = "";
        }
        Page<Book> bookPage = this.iBookService.getAllPageBookByName(name, pageable);
        if (bookPage.isEmpty()) {
            return new ResponseEntity<>(bookPage, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookPage, HttpStatus.OK);
        }
    }
}
