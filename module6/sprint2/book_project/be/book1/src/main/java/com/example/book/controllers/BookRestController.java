package com.example.book.controllers;

import com.example.book.dto.BookDto;
import com.example.book.models.Book;
import com.example.book.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class BookRestController {
    @Autowired
    private IBookService iBookService;


    @GetMapping("/getAllPageBookByName")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
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


    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        if (id == null || id == ' ') {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Book book = this.iBookService.getBookById(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    @PostMapping("/createBook")
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {

        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        this.iBookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/deleteBookById/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
        if (id == null || id == ' ') {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            this.iBookService.deleteBookById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PatchMapping("/editBook")
    public ResponseEntity<Void> editBook(@Valid @RequestBody BookDto bookDto) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        this.iBookService.editBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
