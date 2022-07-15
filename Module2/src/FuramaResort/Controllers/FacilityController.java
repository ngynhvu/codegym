package FuramaResort.Controllers;

import FuramaResort.Models.Facility.House;
import FuramaResort.Models.Facility.Room;
import FuramaResort.Models.Facility.Villa;
import FuramaResort.Services.ClassImpl.BookingServiceImpl;
import FuramaResort.Services.ClassImpl.FacilityServiceImpl;

import java.util.Scanner;


public class FacilityController {
    private static FacilityController facilityController = new FacilityController();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    public void displayFacility(){
        facilityService.displayFacility();
    }
    public void addNewVilla(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of service: ");
        String name = scanner.nextLine();
        System.out.print("Area of service: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Price of service: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.print("Limit people of service: ");
        int people = Integer.parseInt(scanner.nextLine());
        System.out.print("Rental of service: ");
        String rental = scanner.nextLine();
        System.out.print("Standard of service: ");
        String standard = scanner.nextLine();
        System.out.print("Pool Area of service: ");
        double pool = scanner.nextDouble();
        System.out.print("Number of floors: ");
        int floors = scanner.nextInt();
        int value = 1;
        facilityService.addNewVilla(new Villa(name,area,price,people,rental,standard,pool,floors),bookingService.numberUsingVilla());
    }
    public void addNewHouse(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of service: ");
        String name = scanner.nextLine();
        System.out.print("Area of service: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Price of service: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.print("Limit people of service: ");
        int people = Integer.parseInt(scanner.nextLine());
        System.out.print("Rental of service: ");
        String rental = scanner.nextLine();
        System.out.print("Room standard service: ");
        String standard = scanner.nextLine();
        System.out.print("Number of floors: ");
        int floors = scanner.nextInt();
        facilityService.addNewHouse(new House(name,area,price,people,rental,standard,floors),bookingService.numberUsingHouse());
    }
    public void addNewRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of service: ");
        String name = scanner.nextLine();
        System.out.print("Area of service: ");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.print("Price of service: ");
        long price = Long.parseLong(scanner.nextLine());
        System.out.print("Limit people of service: ");
        int people = Integer.parseInt(scanner.nextLine());
        System.out.print("Rental of service: ");
        String rental = scanner.nextLine();
        System.out.print("Free service: ");
        String standard = scanner.nextLine();
        facilityService.addNewRoom(new Room(name,area,price,people,rental,standard),bookingService.numberUsingRoom());
    }
    public void addFacility(){
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 4) {
            System.out.println("Facility Management");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    facilityController.addNewVilla();
                    break;
                case 2:
                    facilityController.addNewHouse();
                    break;
                case 3:
                    facilityController.addNewRoom();
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
