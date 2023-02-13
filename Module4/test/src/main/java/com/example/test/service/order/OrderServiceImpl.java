package com.example.test.service.order;

import com.example.test.model.Order;
import com.example.test.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository repository;
    @Override
    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
