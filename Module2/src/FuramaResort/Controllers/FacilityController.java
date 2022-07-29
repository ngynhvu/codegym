package FuramaResort.Controllers;

import FuramaResort.Models.Facility.House;
import FuramaResort.Models.Facility.Room;
import FuramaResort.Models.Facility.Villa;
import FuramaResort.Services.ClassImpl.BookingServiceImpl;
import FuramaResort.Services.ClassImpl.FacilityServiceImpl;
import FuramaResort.Utils.AreaException;
import FuramaResort.Utils.IdFacillityException;
import FuramaResort.Utils.LimitPeopleException;
import FuramaResort.Utils.PositiveException;

import java.util.Scanner;


public class FacilityController {
    private final String[] typeOfCustomer = {"Diamond", "Platinium", "Gold", "Silver", "Member"};
    private final String[] typeOfRental = {"Year", "Month", "Day", "Hours"};
    Scanner input = new Scanner(System.in);
    private static FacilityController facilityController = new FacilityController();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    public void displayFacilityMaintance(){
        System.out.println("Information Service");
        facilityService.displayFacilityMaintenance();
    }
    public void addNewVilla(){
        System.out.print("ID Service(0-9): SVVL-");
        String idNumber = IdFacillityException.inputAndCheckId();
        String idService = "SVVL-"+ idNumber;
        System.out.print("Area of service: ");
        double area = AreaException.inputAndCheck();
        System.out.print("Price of service: ");
        long price = Long.parseLong(input.nextLine());
        int people = LimitPeopleException.inputAndCheckLimitPeople();
        System.out.print("Rental of service(1.Year, 2.Month, 3.Day, 4.Hours): ");
        System.out.print("Enter choose: ");
        int choose = Integer.parseInt(input.nextLine());
        System.out.print("Standard of service: ");
        String standard = input.nextLine();
        System.out.print("Pool Area of service: ");
        double pool = AreaException.inputAndCheck();
        System.out.print("Number of floors: ");
        int floors = PositiveException.inputAndCheckPositive();
        facilityService.addNewVilla(new Villa(idService, "Villa",area,price,people,typeOfRental[choose-1],standard,pool,floors),bookingService.numberUsingVilla());
    }
    public void addNewHouse(){
        System.out.print("ID Service(0-9): SVHO-");
        String idNumber = IdFacillityException.inputAndCheckId();
        String idService = "SVVL-"+ idNumber;
        System.out.print("Area of service: ");
        double area = AreaException.inputAndCheck();
        System.out.print("Price of service: ");
        long price = Long.parseLong(input.nextLine());
        int people = LimitPeopleException.inputAndCheckLimitPeople();
        System.out.println("Rental of service(1.Year, 2.Month, 3.Day, 4.Hours): ");
        System.out.print("Enter choose: ");
        int choose = Integer.parseInt(input.nextLine());
        System.out.print("Room standard service: ");
        String standard = input.nextLine();
        System.out.print("Number of floors: ");
        int floors = PositiveException.inputAndCheckPositive();
        facilityService.addNewHouse(new House(idService,"House",area,price,people,typeOfRental[choose-1],standard,floors),bookingService.numberUsingHouse());
    }
    public void addNewRoom(){
        System.out.print("ID Service(0-9): SVRO-");
        String idNumber = IdFacillityException.inputAndCheckId();
        String idService = "SVVL-"+ idNumber;
        System.out.print("Area of service: ");
        double area = AreaException.inputAndCheck();
        System.out.print("Price of service: ");
        long price = Long.parseLong(input.nextLine());
        int people = LimitPeopleException.inputAndCheckLimitPeople();
        System.out.print("Rental of service(1.Year, 2.Month, 3.Day, 4.Hours): ");
        System.out.print("Enter choose: ");
        int choose = Integer.parseInt(input.nextLine());
        System.out.print("Free service: ");
        String standard = input.nextLine();
        facilityService.addNewRoom(new Room(idService,"Room",area,price,people,typeOfRental[choose-1],standard),bookingService.numberUsingRoom());
    }
    public void addFacility(){
        int choice = -1;
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
