package com.example.test.service;

import com.example.test.model.Demo;
import com.example.test.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoRepository repository;
    @Override
    public Iterable<Demo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Demo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Demo save(Demo demo) {
        return repository.save(demo);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Demo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
