package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product customer);

    List<Product> findByName (String name);

    void update(Product product);

    void remove(int id);
}
