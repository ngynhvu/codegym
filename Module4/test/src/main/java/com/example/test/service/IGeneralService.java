package com.example.test.service;

import com.example.test.model.Demo;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    Demo save(T t);

    void remove(Long id);
}
