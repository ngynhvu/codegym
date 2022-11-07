package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService extends IGeneralService<Customer>{
   Page<Customer> findAll(Pageable pageable);
   Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
