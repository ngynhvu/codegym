package repository.impl;

import javafx.scene.control.Alert;
import model.Category;
import model.Product;
import repository.ProductRepository;
import utils.ConnectionUtils;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public void create(Product product) throws Exception {
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.INSERT_INTO_PRODUCT);
        ) {
            statement.setInt(1, product.getProductID());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setString(5,product.getColor());
            statement.setString(6, product.getDescription());
            statement.setInt(7,Integer.parseInt(product.getCategory()));
            statement.executeUpdate();
        }

    }

    @Override
    public void update(Product product) throws Exception {
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_PRODUCT);
        ) {
            statement.setInt(1, product.getProductID());
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6,Integer.parseInt(product.getCategory()));
            statement.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(Constants.DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Product findById(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_CUSTOMER_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String nameCategory = rs.getString("ct.name_category");
                return new Product(id,name,price,quantity,color,description,nameCategory);
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Constants.SELECT_ALL_PRODUCT);) {
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String nameCategory = rs.getString("ct.name_category");
                products.add(new Product(id,name,price,quantity,color,description,nameCategory));
            }
        }
        return products;
    }
    public List<Category> displayCategory(){
        List<Category> categories = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Constants.SELECT_ALL_CATEGORY);) {
            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("name_category");
                categories.add(new Category(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
