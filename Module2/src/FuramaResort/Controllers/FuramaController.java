package FuramaResort.Controllers;

import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.ClassImpl.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    public void displayEmployee(){
        for(Employee employee: employeeService.findAll()){
            System.out.println(employee);
        }
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
    public static void employeeManagement(){
        FuramaController furamaController = new FuramaController();
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Employee Management");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employees");
            System.out.println("4. Return menu");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    furamaController.displayEmployee();
                    break;
                case 2:
                    furamaController.addNewEmployee();
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void customerManagement(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Customer Management");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void facilityManagement(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Facility Management");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void bookingManagement(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 6) {
            System.out.println("Booking Management");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return menu");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void promotionManagement(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 3) {
            System.out.println("Promotion Management");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return menu");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 6) {
            System.out.println("Menu");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    customerManagement();
                    break;
                case 3:
                    facilityManagement();
                    break;
                case 4:
                    bookingManagement();
                    break;
                case 5:
                    promotionManagement();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
