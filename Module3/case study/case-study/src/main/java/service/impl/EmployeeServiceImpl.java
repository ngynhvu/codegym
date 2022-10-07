package service.impl;

import model.Employee;
import repository.CustomerRepository;
import repository.EmployeeRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository = new EmployeeRepositoryImpl();
    @Override
    public void create(Employee employee) throws Exception {
        repository.create(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        repository.update(employee);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        return repository.deleteById(id);
    }

    @Override
    public Employee findById(int id) throws SQLException, ClassNotFoundException {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findAll() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }
}
