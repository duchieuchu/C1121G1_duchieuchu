package com.example.controller;

import com.example.model.CardBorrow;
import com.example.service.IBookService;
import com.example.service.ICardBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BorrowBookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICardBorrowService iCardBorrowService;

    @GetMapping(value = "")
    public String goListBorrowBook(Model model) {
        List<CardBorrow> cardBorrowList = iCardBorrowService.findAll();
        model.addAttribute("cardBorrowList", cardBorrowList);
        return "list_borrow_book";
    }
}
