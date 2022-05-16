package com.example.controller;

import com.example.model.Book;
import com.example.model.CardBorrow;
import com.example.service.IBookService;
import com.example.service.ICardBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICardBorrowService iCardBorrowService;

    @GetMapping(value = "")
    public String goListBook(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list_book";
    }

    @GetMapping(value = "/borrow")
    public String showBorrowBook(Model model, @RequestParam int id, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(id);
        if (book.getRemainTotal() == 0) {
            redirectAttributes.addFlashAttribute("mess", "Ran out of books to borrow");
            return "redirect:/book/";
        }
        iBookService.reduceNumberOfBook(book);
        CardBorrow cardBorrow = new CardBorrow();
        iBookService.copy(book, cardBorrow);
        model.addAttribute("cardBorrow", cardBorrow);
        return "borrow_book";
    }

    @PostMapping(value = "/saveBorrowBook")
    public String saveBB(@ModelAttribute CardBorrow cardBorrow, RedirectAttributes redirectAttributes) {
        iCardBorrowService.save(cardBorrow);
        redirectAttributes.addFlashAttribute("mess", "Borrow Book Success");
        return "redirect:/book/";
    }

}
