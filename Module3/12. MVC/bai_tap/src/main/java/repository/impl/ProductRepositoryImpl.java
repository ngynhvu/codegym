package repository.impl;

import bean.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements repository.ProductRepository {
    private static Map<String, Product> map;
    static {
        map.put("PRO1",new Product("PRO1", "Phone", 1300000,new Date(), 4, "good"));
        map.put("PRO2",new Product("PRO2", "Tivi", 10000000,new Date(), 6, "good"));
        map.put("PRO3",new Product("PRO3", "Robot", 6500000,new Date(), 7, "good"));
        map.put("PRO4",new Product("PRO4", "Laptop", 30000000,new Date(), 1, "good"));
        map.put("PRO5",new Product("PRO5", "Airpod", 5200000,new Date(), 10, "good"));
    }

    @Override
    public void create(Product product) throws Exception {
        if(map.containsKey(product.getIdProduct())){
            throw new Exception("Duplicate key");
        }
        map.put(product.getIdProduct(),product);
    }

    @Override
    public void update(Product product) throws Exception {
        if(map.containsKey(product.getIdProduct())){
            map.put(product.getIdProduct(),product);
            return;
        }
        throw new Exception("Product ID not exist");
    }

    @Override
    public void deleteById(String id) throws Exception {
        if (map.containsKey(id)) {
            map.remove(id);
            return;
        }
        throw new Exception("Product ID not exist");
    }

    @Override
    public Product findById(String id) {
        return map.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }
}
