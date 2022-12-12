package com.example.furamamanagerment.service.employee.education;

import com.example.furamamanagerment.model.employee.Education;
import com.example.furamamanagerment.repository.employee.education.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService{
    @Autowired
    private EducationRepository repository;

    @Override
    public Iterable findAll() {
        return repository.findAll();
    }

    @Override
    public Optional findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Education education) {
        repository.save(education);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
