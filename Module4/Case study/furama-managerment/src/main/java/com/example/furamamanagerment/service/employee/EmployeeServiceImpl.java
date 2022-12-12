package com.example.furamamanagerment.service.employee;

import com.example.furamamanagerment.model.employee.Employee;
import com.example.furamamanagerment.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
