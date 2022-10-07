package service.impl;

import model.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository = new CustomerRepositoryImpl();
    @Override
    public void create(Customer customer) throws Exception {
        repository.create(customer);
    }

    @Override
    public void update(Customer customer) throws Exception {
        repository.update(customer);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        return repository.deleteById(id);
    }

    @Override
    public Customer findById(int id) throws SQLException, ClassNotFoundException {
        return repository.findById(id);
    }

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }
}
