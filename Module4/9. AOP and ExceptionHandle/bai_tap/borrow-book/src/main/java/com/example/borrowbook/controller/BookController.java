package com.example.borrowbook.controller;

import com.example.borrowbook.RandomID;
import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.BorrowBook;
import com.example.borrowbook.service.BookService;
import com.example.borrowbook.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private BorrowBookService borrowService;
    @Autowired
    private RandomID randomID;

    @GetMapping("/create-book")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute("book") Book book) {
        service.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("message", "New book created successfully");
        return modelAndView;
    }

    @GetMapping("/books")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books", service.findAll());
        return modelAndView;
    }
    @GetMapping("/detail-book/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        Optional<Book> book = service.findById(id);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/book/deatail");
            modelAndView.addObject("book", book.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @GetMapping("/borrow-book")
    public ModelAndView showBorrowForm() {
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setBorrowID(randomID.IDBorrow());
        ModelAndView modelAndView = new ModelAndView("/book/borrow");
        modelAndView.addObject("books", service.findAll());
        modelAndView.addObject("borrowBook",  borrowBook );
        return modelAndView;
    }

    @PostMapping("/borrow-book")
    public ModelAndView borrowBook(@ModelAttribute("borrowBook") BorrowBook borrowBook) {
        Book book = borrowBook.getBook();
        int quatity = book.getQuantity();
        book.setQuantity(quatity-1);
        service.save(book);
        borrowService.save(borrowBook);
        ModelAndView modelAndView = new ModelAndView("/book/borrow");
        modelAndView.addObject("borrowBook", new BorrowBook());
        modelAndView.addObject("message", "New book created successfully");
        return modelAndView;
    }

}
