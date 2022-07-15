package FuramaResort.Services.ClassImpl;

import FuramaResort.Models.Booking;
import FuramaResort.Models.Contract;
import FuramaResort.Services.BookingComparator;
import FuramaResort.Services.Interface.BookingService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;


public class BookingServiceImpl implements BookingService {
    private static TreeSet<Booking> bookingTreeSet = new TreeSet<Booking>(new BookingComparator());
    private static TreeSet<Contract> contractTreeSet = new TreeSet<>();
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    @Override
    public void addBooking(Booking booking) {
        bookingTreeSet.add(booking);
        bookingQueue.add(booking);
    }

    @Override
    public void displayBooking() {
        for(Booking booking: bookingTreeSet){
            System.out.println(booking.toString());
        }
    }
    public int numberUsingVilla(){
        int count = 0;
        for (Booking booking: bookingQueue) {
            if(booking.getNameOfService() == "Villa"){
                return count++;
            }
        }return 0;
    }
    public int numberUsingHouse(){
        int count = 0;
        for (Booking booking: bookingQueue) {
            if(booking.getNameOfService() == "House"){
                return count++;
            }
        }return 0;
    }
    public int numberUsingRoom(){
        int count = 0;
        for (Booking booking: bookingQueue) {
            if(booking.getNameOfService() == "Room"){
                return count++;
            }
        }return 0;
    }

    public void addNewContract(){
        Scanner input =new Scanner(System.in);
        for(Booking booking: bookingQueue){
            int numberOfContract= 1;
            System.out.println("Booking ID: "+ booking.getBookingID());
            System.out.print("Money of deposit: ");
            long deposit = input.nextLong();
            System.out.print("Money of payment: ");
            long payment = input.nextLong();
            System.out.println("Customer ID: "+ booking.getCustomerID());
            contractTreeSet.add(new Contract(numberOfContract, booking.getBookingID(),deposit,payment, booking.getCustomerID()));
            numberOfContract++;
        }
    }
}
