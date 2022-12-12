package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerServiceAPI {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    void remove(Long id);

    List<Customer> findFirstName(String firstName);
}
