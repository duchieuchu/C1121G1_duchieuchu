package com.example.controller;

import com.example.model.Book;
import com.example.model.CardBorrow;
import com.example.service.IBookService;
import com.example.service.ICardBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICardBorrowService iCardBorrowService;

    @GetMapping(value = "")
    public String list(@PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Book> books = this.iBookService.getAll(pageable);
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping(value = "/listCard")
    public String listCard(@PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<CardBorrow> cardBorrows = this.iCardBorrowService.getAll(pageable);
        model.addAttribute("cardBorrows", cardBorrows);
        return "listCard";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Book book, RedirectAttributes redirectAttributes) {
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("mess", "Create book Completed");
        return "redirect:/book";
    }

    @GetMapping("/delete")
    public String delete(Book book, RedirectAttributes redirectAttributes) {
        this.iBookService.remove(book);
        redirectAttributes.addFlashAttribute("mess", "Delete book Completed");
        return "redirect:/book";
    }

    @GetMapping("/borrow-book/{id}")
    public String borrow(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws Exception {
        Book book = this.iBookService.getOne(id);
        if (book.getQuantity() <= 0) {
            throw new Exception("het sach");
        }
        book.setQuantity(book.getQuantity() - 1);


        CardBorrow cardBorrow = new CardBorrow();
        long code = (long) (Math.random() * 89999 + 10000);
        cardBorrow.setCode(Long.toString(code));
        //lien ket thong tin
        cardBorrow.setBook(book);
        cardBorrow.setBorrowStartDate(LocalDate.now().toString());
        this.iCardBorrowService.save(cardBorrow);
        redirectAttributes.addFlashAttribute("mess", "borrow book Completed" + "your code to return book is " + code);
        return "redirect:/book";
    }

    @GetMapping("return-book")
    public String listReturnBook(@RequestParam String code) {
        this.iCardBorrowService.checkGiveBack(code);
        CardBorrow cardBorrow = this.iCardBorrowService.checkGiveBack(code);
        cardBorrow.getBook().setQuantity(cardBorrow.getBook().getQuantity() + 1);

        this.iBookService.save(cardBorrow.getBook());
        this.iCardBorrowService.remove(cardBorrow);
        return "redirect:/book";
    }

    //hien thi
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.getOne(id));

        return "/view";
    }

    @ExceptionHandler(NullPointerException.class)
    public String showNullErrorPage() {
        return "error1";
    }

    @ExceptionHandler(Exception.class)
    public String showSmallThanZeroException() {
        return "error";
    }
}
