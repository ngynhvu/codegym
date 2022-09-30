package repository.impl;

import model.Customer;
import model.CustomerType;
import utils.ConnectionUtils;
import utils.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerTypeRepositoryImpl {
    public List<CustomerType> findAll() throws SQLException, ClassNotFoundException {
        List<CustomerType> customerTypes = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Constants.SELECT_ALL_FROM_CUSTOMER_TYPE);) {
            while (rs.next()) {
                int id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_type_name");
                customerTypes.add(new CustomerType(id,name));
            }
        }
        return customerTypes;
    }
}
