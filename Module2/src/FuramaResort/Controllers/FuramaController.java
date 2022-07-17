package FuramaResort.Controllers;

import FuramaResort.Models.Person.Customer;
import FuramaResort.Models.Person.Employee;
import FuramaResort.Services.ClassImpl.CustomerServiceImpl;
import FuramaResort.Services.ClassImpl.EmployeeServiceImpl;
import FuramaResort.Services.ClassImpl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private static FuramaController furamaController = new FuramaController();
    private static EmployeeController employeeController = new EmployeeController();
    private static CustomerController customerController = new CustomerController();
    private static FacilityController facilityController = new FacilityController();
    private static BookingController bookingController = new BookingController();
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    public static void employeeManagement(){
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
                    employeeController.displayEmployee();
                    break;
                case 2:
                    employeeController.addNewEmployee();
                    break;
                case 3:
                    employeeController.editEmployee();
                    break;
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
                    customerController.displayCustomer();
                    break;
                case 2:
                    customerController.addNewCustomer();
                    break;
                case 3:
                    customerController.editCustomer();
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }

    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    public void displayFacility(){
        facilityService.displayFacility();
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
                    furamaController.displayFacility();
                    break;
                case 2:
                    facilityController.addFacility();
                    break;
                case 3:
                    break;
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
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return menu");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    bookingController.addNewBooking();
                    break;
                case 2:
                    bookingController.displayListBooking();
                    break;
                case 3:
                    bookingController.addNewContract();
                    break;
                case 4:
                    bookingController.displayListContract();
                    break;
                case 5:
                    bookingController.editContracts();
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
}
