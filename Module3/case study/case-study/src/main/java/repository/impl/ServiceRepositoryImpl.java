package repository.impl;

import model.Customer;
import model.Service;
import repository.ServiceRepository;
import utils.ConnectionUtils;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {

    @Override
    public void create(Service service) throws Exception {
        if (findById(service.getServiceId()) != null) {
            throw new Exception("Duplicate key");
        }
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.INSERT_INTO_SERVICE);
        ) {
            statement.setInt(1, service.getServiceId());
            statement.setString(2, service.getServiceName());
            statement.setInt(3, service.getServiceArea());
            statement.setDouble(4, service.getService_cost());
            statement.setInt(5, service.getPeople());
            statement.setInt(6, service.getRentTypeId());
            statement.setInt(7, service.getServiceTypeId());
            statement.setString(8, service.getStandardRoom());
            statement.setString(9, service.getOther());
            statement.setDouble(10, service.getPoolArea());
            statement.setDouble(11, service.getFloors());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Service service) throws Exception {
        if (findById(service.getServiceId()) == null) {
            throw new Exception("Service ID not exist");
        }
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_CUSTOMER);
        ) {
            statement.setInt(11, service.getServiceId());
            statement.setString(1, service.getServiceName());
            statement.setInt(2, service.getServiceArea());
            statement.setDouble(3, service.getService_cost());
            statement.setInt(4, service.getPeople());
            statement.setInt(5, service.getRentTypeId());
            statement.setInt(6, service.getServiceTypeId());
            statement.setString(7, service.getStandardRoom());
            statement.setString(8, service.getOther());
            statement.setDouble(9, service.getPoolArea());
            statement.setDouble(10, service.getFloors());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(Constants.DELETE_SERVICE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Service findById(int id) throws SQLException, ClassNotFoundException {
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
//                return new Customer(id,type_id,name,birthday,gender,idCard,phone,email,address);
            }
        }
        return null;
    }

    @Override
    public List<Service> findAll() throws SQLException, ClassNotFoundException {
        List<Service> services = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Constants.SELECT_ALL_FROM_SERVICE);) {
            while (rs.next()) {
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int people = rs.getInt("service_max_people");
                int rentId = rs.getInt("rent_type_id");
                int serviceId = rs.getInt("service_type_id");
                String room = rs.getString("standard_room");
                String other = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int floors = rs.getInt("number_of_floors");
                services.add(new Service(id,name,area,cost,people,rentId,serviceId,room,other,poolArea,floors));
            }
        }
        return services;
    }
}
