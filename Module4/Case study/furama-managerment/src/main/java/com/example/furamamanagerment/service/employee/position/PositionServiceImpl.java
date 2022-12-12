package com.example.furamamanagerment.service.employee.position;

import com.example.furamamanagerment.model.employee.Position;
import com.example.furamamanagerment.repository.employee.position.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionRepository repository;
    @Override
    public Iterable<Position> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Position> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Position position) {
        repository.save(position);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
