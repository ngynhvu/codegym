package service.impl;

import model.Category;
import model.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository repository = new ProductRepositoryImpl();
    private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    @Override
    public void create(Product product) throws Exception {
        repository.create(product);
    }

    @Override
    public void update(Product product) throws Exception {
        repository.update(product);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        return repository.deleteById(id);
    }

    @Override
    public Product findById(int id) throws SQLException, ClassNotFoundException {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        return repository.findAll();
    }
    public List<Category> displayCategory(){
        return productRepository.displayCategory();
    }
}
