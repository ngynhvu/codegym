package service;

import bean.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public void create(Product product) throws Exception {
        repository.create(product);
    }

    @Override
    public void update(Product product) throws Exception {
        repository.update(product);
    }

    @Override
    public void deleteById(String id) throws Exception {
        repository.deleteById(id);
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
