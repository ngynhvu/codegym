package com.example.borrowbook.service;

import com.example.borrowbook.model.BorrowBook;

import java.util.Optional;

public interface BorrowBookService{
    Optional<BorrowBook> findById(String id);

    void remove(String id);
    Iterable<BorrowBook> findAll();


    void save(BorrowBook borrowBook);

}
