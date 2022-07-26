package FuramaResort.Services.ClassImpl;

import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.Interface.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeesList = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return employeesList;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeesList.add(employee);

    }

    @Override
    public void editEmployee(int idEmployee) {
        Scanner scanner = new Scanner(System.in);
        for(Employee employee: employeesList){
            if(employee.getEmployeeID() == idEmployee){
                System.out.print("Full name Employee: ");
                String name = scanner.nextLine();
                System.out.print("Date of Birth Employee: ");
                String date = scanner.nextLine();
                System.out.print("Sex(Male or Female): ");
                String sex  = scanner.nextLine();
                System.out.print("CMND: ");
                String cmnd = scanner.nextLine();
                System.out.print("Phone number Employee: ");
                String phone = scanner.nextLine();
                System.out.print("Email Employee: ");
                String email = scanner.nextLine();
                System.out.print("Level Employee: ");
                String level = scanner.nextLine();
                System.out.print("Position Employee: ");
                String position = scanner.nextLine();
                System.out.print("Salary Employee: ");
                long salary = scanner.nextLong();
                employee.setFullName(name);
                employee.setDateOfBirth(date);
                employee.setSex(sex);
                employee.setNumberCMND(cmnd);
                employee.setPhoneNumber(phone);
                employee.setEmail(email);
                employee.setLevel(level);
                employee.setPosition(position);
                employee.setSalary(salary);
                break;
            }else {
                System.out.println("Not Found");
            }
        }
    }
}
