package com.example.controller;

import com.example.model.Book;
import com.example.model.BookType;
import com.example.model.CardBorrow;
import com.example.service.IBookService;
import com.example.service.IBookTypeService;
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
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private ICardBorrowService iCardBorrowService;

    @Autowired
    private IBookTypeService iBookTypeService;

    @GetMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Book> bookPage = iBookService.findAll(pageable);
        model.addAttribute("bookPage", bookPage);
        return "/listBook";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<BookType> bookTypeList = iBookTypeService.findAll();
        model.addAttribute("bookTypeList", bookTypeList);
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/add")
    public String create(Book book) {
        iBookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        iBookService.delete(iBookService.findById(id));
        return "redirect:/book";
    }

    @GetMapping("/listCard")
    public String showListCard(Model model, @PageableDefault(value = 6) Pageable pageable) {
        Page<CardBorrow> cardBorrowPage = iCardBorrowService.findAll(pageable);
        model.addAttribute("cardBorrowPage", cardBorrowPage);
        return "/listCard";
    }

    @GetMapping("/{id}/borrow-book")
    public String borrow(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getQuantity() <= 0) {
//            return "/errorBook";
            throw new Exception();
        }
//        book.setQuantity(book.getQuantity() - 1);
        iBookService.updateQuantityDown(id);
        CardBorrow cardBorrow = new CardBorrow();
        int code = (int) (Math.random() * 99999);

        cardBorrow.setCode(Integer.toString(code));
        cardBorrow.setBook(book);
        cardBorrow.setBorrowDate(LocalDate.now().toString());
        iCardBorrowService.save(cardBorrow);
        redirectAttributes.addFlashAttribute("mess", "đã mươn sách thành công, mã mượn sách của bạn là : " + code);

        return "redirect:/book";
    }

    @GetMapping("return-book")
    public String listReturnBook(@RequestParam String code) {
        this.iCardBorrowService.findByCode(code);
        CardBorrow cardBorrow = this.iCardBorrowService.findByCode(code);
        cardBorrow.getBook().setQuantity(cardBorrow.getBook().getQuantity() + 1);

        this.iBookService.save(cardBorrow.getBook());
        this.iCardBorrowService.delete(cardBorrow);
        return "redirect:/book";
    }
    @GetMapping("/{id}/view")
    public String goDetailBook(@PathVariable Integer id,Model model){
        model.addAttribute("book",iBookService.findById(id));
        return "/view";
    }

    @ExceptionHandler(Exception.class)
    public String goErrorQuantity() {
        return "/errorBook";
    }

}
