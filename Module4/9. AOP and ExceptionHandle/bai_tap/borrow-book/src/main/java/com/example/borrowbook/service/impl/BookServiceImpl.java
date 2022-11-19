package com.example.borrowbook.service.impl;

import com.example.borrowbook.model.Book;
import com.example.borrowbook.repository.BookRepository;
import com.example.borrowbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;
    @Override
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
