package service.impl;

import model.Service;
import repository.CustomerRepository;
import repository.ServiceRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.ServiceRepositoryImpl;
import service.ServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements ServiceService{
    private ServiceRepository repository = new ServiceRepositoryImpl();
    @Override
    public void create(Service service) throws Exception {
        repository.create(service);
    }

    @Override
    public void update(Service service) throws Exception {
        repository.update(service);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        return repository.deleteById(id);
    }

    @Override
    public Service findById(int id) throws SQLException, ClassNotFoundException {
        return repository.findById(id);
    }

    @Override
    public List<Service> findAll() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }
}
