package FuramaResort.Controllers;

import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.ClassImpl.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    private static FuramaController furamaController = new FuramaController();
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    public void displayEmployee(){
        for(Employee employee: employeeService.findAll()){
            System.out.println(employee);
        }
    }
    public void editEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id employee: ");
        int id = scanner.nextInt();
        employeeService.editEmployee(id);
    }
    public void addNewEmployee(){
        Scanner scanner = new Scanner(System.in);
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
        System.out.print("Id Employee: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Level Employee: ");
        String level = scanner.nextLine();
        System.out.print("Position Employee: ");
        String position = scanner.nextLine();
        System.out.print("Salary Employee: ");
        long salary = scanner.nextLong();
        employeeService.addEmployee(new Employee(name, date, sex, cmnd,phone,email,id, level, position, salary));
    }
}
