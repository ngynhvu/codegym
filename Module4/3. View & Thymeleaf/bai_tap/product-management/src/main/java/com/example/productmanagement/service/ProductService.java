package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService{
    private static final List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Phone", 120000000, 2,"Red"));
        products.add(new Product(2,"Tivi", 513510000, 6,"Bleck"));
        products.add(new Product(3,"Air Conditional", 50000000, 9,"White"));
        products.add(new Product(4,"Laptop", 250000000, 2,"Gold"));
        products.add(new Product(5,"Mouse", 1000000, 10,"Red"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> findList = new ArrayList<>();
        for(Product product:products){
            if(product.getNameProduct().equals(name)){
                findList.add(product);
            }
        }
        return findList;
    }

    @Override
    public void update(Product product) {
        for (Product product1: products){
            if(product1.getIdProduct() == product.getIdProduct()){
                product1.setNameProduct(product.getNameProduct());
                product1.setPrice(product.getPrice());
                product1.setQuantity(product.getQuantity());
                product1.setDescription(product.getDescription());
            }
        }
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
