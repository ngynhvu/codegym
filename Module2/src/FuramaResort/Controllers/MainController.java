package FuramaResort.Controllers;

import java.util.Scanner;

public class MainController {
    private static FuramaController furamaController = new FuramaController();
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
                    furamaController.employeeManagement();
                    break;
                case 2:
                    furamaController.customerManagement();
                    break;
                case 3:
                    furamaController.facilityManagement();
                    break;
                case 4:
                    furamaController.bookingManagement();
                    break;
                case 5:
                    furamaController.promotionManagement();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
