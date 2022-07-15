package FuramaResort.Controllers;

import FuramaResort.Models.Booking;

import FuramaResort.Services.ClassImpl.BookingServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class BookingController {
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
        System.out.print("Name of service: ");
        String nameService = input.nextLine();
//        bookingService.numberUsingVilla(nameService);
        System.out.print("Type of service: ");
        String type = input.nextLine();
        bookingService.addBooking(new Booking(id,startDay,endDay,customerID,nameService,type));
    }
    public void displayListBooking(){
        bookingService.displayBooking();
    }
    public void addNewContract(){
        bookingService.addNewContract();
    }
}
