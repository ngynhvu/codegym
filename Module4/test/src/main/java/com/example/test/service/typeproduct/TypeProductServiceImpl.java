package com.example.test.service.typeproduct;

import com.example.test.model.TypeProduct;
import com.example.test.repository.ProductRepository;
import com.example.test.repository.TypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeProductServiceImpl implements TypeProductService{
    @Autowired
    private TypeProductRepository repository;

    @Override
    public Iterable<TypeProduct> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TypeProduct> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(TypeProduct typeProduct) {

    }

    @Override
    public void remove(int id) {

    }
}
