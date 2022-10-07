package utils;

public interface Constants {
    String SELECT_ALL_FROM_CUSTOMER = "Select * from customer";
    String INSERT_INTO_CUSTOMER = "Insert into customer values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_CUSTOMER = "Update customer set customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone =?, customer_email = ?, customer_address=? where customer_id = ?";
    String FIND_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    String SELECT_ALL_FROM_CUSTOMER_TYPE = "Select * from customer_type";
    String DELETE_USERS_SQL = "delete from customer where customer_id = ?;";
    String FIND_TYPE_CUSTOMER = "select customer_type_name where customer_type_id=?";
    String SELECT_ALL_FROM_SERVICE = "select * from service";
    String DELETE_SERVICE = "delete from service where service_id = ?;";
    String UPDATE_SERVICE = "";
    String INSERT_INTO_SERVICE = "insert into service values(?, ?,?,?,?,?,?,?,?,?,?)";

    String INSERT_INTO_EMPLOYEE = "Insert into employee values(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
    String FIND_EMPLOYEE = "select * from employee where employee_id = ?";
    String SELECT_ALL_EMPLOYEE = "select * from employee";
    String UPDATE_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?,division_id = ?,username = ? where employee_id=?";
    String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
}
