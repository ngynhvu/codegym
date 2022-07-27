package FuramaResort.Controllers;

import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.ClassImpl.EmployeeServiceImpl;
import FuramaResort.Services.WriteReadFileCSV;
import FuramaResort.Utils.*;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private final String[] levelEmployee = {"Intermediate", "College", "University", "After university"};
    private final String[] postionEmployee = {"Receptionist", "Service", "Specialist", "Supervisor", "Manager", "Director"};
    private static FuramaController furamaController = new FuramaController();
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    BirthdayException birthdayException = new BirthdayException();
    public void displayEmployee(){
        List<Employee> employeeList = WriteReadFileCSV.readEmloyeeCSV();
        for(Employee employee: employeeList){
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
        String date = birthdayException.inputAndCheckBirthday18();
        System.out.print("Sex(1.Male, 2.Female, 3.Other): ");
        String sex  = GenderException.inputAndCheck();
        System.out.print("CMND: ");
        String cmnd = CMNDException.inputAndCheckId();
        System.out.print("Phone number Employee: ");
        String phone = CMNDException.inputAndCheckId();
        System.out.print("Email Employee: ");
        String email = scanner.nextLine();
        System.out.print("Id Employee: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Level Employee(1.Intermediate, 2.College, 3.University, 4.After university): ");
        int choose = LevelException.inputAndCheck();
        System.out.print("Position Employee(1.Receptionist, 2.Service, 3.Specialist, 4.Supervisor, 5.Manager, 6.Director): ");
        int choosePosition = PostionException.inputAndCheck();
        System.out.print("Salary Employee: ");
        long salary = Long.parseLong(scanner.nextLine());
        employeeService.addEmployee(new Employee(name, date, sex, cmnd,phone,email,id, levelEmployee[choose-1], postionEmployee[choosePosition-1], salary));
    }
}
