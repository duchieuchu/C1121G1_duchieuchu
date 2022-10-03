package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookRestController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/getAllPageBookByName")
    public ResponseEntity<Page<Book>> getAllPageBookByName(@PageableDefault(9) Pageable pageable,
                                                           Optional<String> bookName) {
        String name = bookName.orElse("");
        if (name.equals("null")) {
            name = "";
        }
        Page<Book> bookPage = this.iBookService.getAllPageBookByName(name, pageable);
        if (bookPage.isEmpty()) {
            return new ResponseEntity<>(bookPage,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookPage, HttpStatus.OK);
        }
    }
}
