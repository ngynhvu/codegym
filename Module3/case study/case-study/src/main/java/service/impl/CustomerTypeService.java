package service.impl;

import model.Customer;
import model.CustomerType;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.CustomerTypeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerTypeService {
    private CustomerTypeRepositoryImpl repository = new CustomerTypeRepositoryImpl();
    public List<CustomerType> findAll() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }
}
