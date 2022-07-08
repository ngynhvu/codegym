package FuramaResort.Services.Interface;

import FuramaResort.Models.Person.Employee;


import java.util.List;

public interface EmployeeService extends Service{
    List<Employee> findAll();
    void addEmployee(Employee employee);
    void editEmployee(int idEmployee);
}
