package FuramaResort.Controllers;

import FuramaResort.Models.Booking;

import FuramaResort.Models.Facility.Villa;
import FuramaResort.Services.ClassImpl.BookingServiceImpl;
import FuramaResort.Utils.NameServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class BookingController {
    private final String[] typeOfRental = {"Year", "Month", "Day", "Hours"};
    private static BookingController bookingController = new BookingController();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    public void addNewBooking(){
        Scanner input = new Scanner(System.in);
        System.out.print("Booking ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Start day: ");
        String startDay = input.nextLine();
        System.out.print("End day: ");
        String endDay = input.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        try{
            dateFormat.parse(startDay);
            dateFormat.parse(endDay);
        }
        catch (ParseException e){
            System.out.println("Invalid date");
        }
        System.out.print("Customer ID: ");
        int customerID = Integer.parseInt(input.nextLine());
        System.out.print("Name of service(1.Villa, 2.House, 3. Room: ");
        String nameService = NameServiceException.inputAndCheck();
        System.out.print("Rental of service(1.Year, 2.Month, 3.Day, 4.Hours): ");
        System.out.print("Enter choose: ");
        int choose = Integer.parseInt(input.nextLine());
        bookingService.addBooking(new Booking(id,startDay,endDay,customerID,nameService,typeOfRental[choose-1]));
    }
    public void displayListBooking(){
        bookingService.displayBooking();
    }
    public void displayListContract(){
        bookingService.displayContract();
    }
    public void addNewContract(){
        bookingService.addNewContract();
    }
    public void editContracts(){
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        bookingService.editContract(id);}

}
