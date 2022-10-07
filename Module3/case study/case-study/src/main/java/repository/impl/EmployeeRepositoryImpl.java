package repository.impl;

import model.Customer;
import model.Employee;
import repository.EmployeeRepository;
import utils.ConnectionUtils;
import utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public void create(Employee employee) throws Exception {
        if (findById(employee.getEmployeeId()) != null) {
            throw new Exception("Duplicate key");
        }
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.INSERT_INTO_EMPLOYEE);
        ) {
            statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getEmployeeName());
            statement.setDate(3, new java.sql.Date(employee.getEmployeeBirthday().getTime()));
            statement.setString(4,employee.getEmployeeIdCard());
            statement.setDouble(5,employee.getEmployeeSalary());
            statement.setString(6, employee.getEmployeePhone());
            statement.setString(7, employee.getEmployeeEmail());
            statement.setString(8,employee.getEmployeeAddress());
            statement.setInt(9, employee.getPositionId());
            statement.setInt(10, employee.getEducationId());
            statement.setInt(11, employee.getDivisionId());
            statement.setString(12, employee.getUsername());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Employee employee) throws Exception {
        if (findById(employee.getEmployeeId()) == null) {
            throw new Exception("Employee ID not exist");
        }
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE);
        ) {
            statement.setInt(12, employee.getEmployeeId());
            statement.setString(1, employee.getEmployeeName());
            statement.setDate(2, new java.sql.Date(employee.getEmployeeBirthday().getTime()));
            statement.setString(3,employee.getEmployeeIdCard());
            statement.setDouble(4,employee.getEmployeeSalary());
            statement.setString(5, employee.getEmployeePhone());
            statement.setString(6, employee.getEmployeeEmail());
            statement.setString(7,employee.getEmployeeAddress());
            statement.setInt(8, employee.getPositionId());
            statement.setInt(9, employee.getEducationId());
            statement.setInt(10, employee.getDivisionId());
            statement.setString(11, employee.getUsername());
            statement.executeUpdate();
        }
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Employee findById(int id) throws SQLException, ClassNotFoundException {
        try (
                Connection connection = ConnectionUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constants.FIND_EMPLOYEE);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("employee_name");
                Date birthday = new Date(rs.getDate("employee_birthday").getTime());
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int position  = rs.getInt("position_id");
                int education  = rs.getInt("education_degree_id");
                int division  = rs.getInt("division_id");
                String username = rs.getString("username");
                return new Employee(id,name,birthday,idCard,salary,phone,email,address,position,education,division,username);
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAll() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(Constants.SELECT_ALL_EMPLOYEE);) {
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                Date birthday = new Date(rs.getDate("employee_birthday").getTime());
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int position  = rs.getInt("position_id");
                int education  = rs.getInt("education_degree_id");
                int division  = rs.getInt("division_id");
                String username = rs.getString("username");
                employees.add(new Employee(id,name,birthday,idCard,salary,phone,email,address,position,education,division,username));
            }
        }
        return employees;
    }
}
