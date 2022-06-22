package FuramaResort.Controllers;

import java.util.Scanner;

public class FuramaController {
    public static void employeeManagement(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employees");
            System.out.println("4. Return menu");
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
    public static void customerManagement(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Menu");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employees");
            System.out.println("4. Return menu");
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
                    System.out.println("Draw the square");
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
