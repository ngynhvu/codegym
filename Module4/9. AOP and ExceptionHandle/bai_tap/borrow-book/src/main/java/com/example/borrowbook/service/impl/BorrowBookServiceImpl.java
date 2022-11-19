package com.example.borrowbook.service.impl;

import com.example.borrowbook.model.BorrowBook;
import com.example.borrowbook.repository.BorrowBookRepository;
import com.example.borrowbook.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

    @Autowired
    private BorrowBookRepository repository;
    @Override
    public Optional<BorrowBook> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void remove(String id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<BorrowBook> findAll() {
        return repository.findAll();
    }
    @Override
    public void save(BorrowBook borrowBook) {
        repository.save(borrowBook);
    }


}
