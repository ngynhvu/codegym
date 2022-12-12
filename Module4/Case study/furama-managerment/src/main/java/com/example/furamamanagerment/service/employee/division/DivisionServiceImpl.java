package com.example.furamamanagerment.service.employee.division;

import com.example.furamamanagerment.model.employee.Division;
import com.example.furamamanagerment.repository.employee.division.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    private DivisionRepository repository;

    @Override
    public Iterable<Division> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Division> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Division division) {
        repository.save(division);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
