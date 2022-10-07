package repository.impl;

import model.Customer;
import repository.CustomerRepository;
import utils.ConnectionUtils;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void create(Customer customer) throws Exception {
        if (findById(customer.getCustomerId()) != null) {
            throw new Exception("Duplicate key");
        }
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.INSERT_INTO_CUSTOMER);
        ) {
            statement.setInt(1, customer.getCustomerId());
            statement.setInt(2, customer.getCustomerTypeId());
            statement.setString(3, customer.getCustomerName());
            statement.setDate(4, new java.sql.Date(customer.getCustomerBirthday().getTime()));
            statement.setBoolean(5, customer.isCustomerGender());
            statement.setString(6,customer.getCustomerIdCard());
            statement.setString(7, customer.getCustomerPhone());
            statement.setString(8, customer.getCustomerEmail());
            statement.setString(9,customer.getCustomerAddress());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Customer customer) throws Exception {
        if (findById(customer.getCustomerId()) == null) {
            throw new Exception("Product ID not exist");
        }
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_CUSTOMER);
        ) {
            statement.setInt(9, customer.getCustomerId());
            statement.setInt(1, customer.getCustomerTypeId());
            statement.setString(2, customer.getCustomerName());
            statement.setDate(3, new java.sql.Date(customer.getCustomerBirthday().getTime()));
            statement.setBoolean(4, customer.isCustomerGender());
            statement.setString(5, customer.getCustomerIdCard());
            statement.setString(6, customer.getCustomerPhone());
            statement.setString(7, customer.getCustomerEmail());
            statement.setString(8, customer.getCustomerAddress());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(Constants.DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Customer findById(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_CUSTOMER_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int type_id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                Date birthday = new Date(rs.getDate("customer_birthday").getTime());
                boolean gender = rs.getBoolean("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                return new Customer(id,type_id,name,birthday,gender,idCard,phone,email,address);
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Constants.SELECT_ALL_FROM_CUSTOMER);) {
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                int type_id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                Date birthday = new Date(rs.getDate("customer_birthday").getTime());
                boolean gender = rs.getBoolean("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id,type_id,name,birthday,gender,idCard,phone,email,address));
            }
        }
        return customers;
    }

}
