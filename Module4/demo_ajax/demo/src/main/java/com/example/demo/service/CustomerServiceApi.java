package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceApi implements ICustomerServiceAPI {
    @Autowired
    private ICustomerRepository repository;


    @Override
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> findFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }
}
