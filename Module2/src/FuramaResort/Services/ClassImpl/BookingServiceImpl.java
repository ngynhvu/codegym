package FuramaResort.Services.ClassImpl;

import FuramaResort.Models.Booking;
import FuramaResort.Models.Contract;
import FuramaResort.Services.BookingComparator;
import FuramaResort.Services.ContractComparator;
import FuramaResort.Services.Interface.BookingService;
import FuramaResort.Services.WriteReadFileCSV;
import FuramaResort.Utils.BookingCheck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;


public class BookingServiceImpl implements BookingService {
    private static TreeSet<Booking> bookingTreeSet = new TreeSet<Booking>(new BookingComparator());
    private static TreeSet<Contract> contractTreeSet = new TreeSet<>(new ContractComparator());
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    public void displayUsingService(){
        System.out.println("Information customer using service: ");
        if(bookingTreeSet.isEmpty()){
            System.out.println("No customer");
        }else {
            for(Booking booking: bookingTreeSet){
                if(booking.getNameOfService() == "Villa"|| booking.getNameOfService() == "House"){
                    System.out.println("Id customer = "+ booking.getCustomerID()+", Service = "+booking.getNameOfService() + ", Years using = "+ booking.getStartDay().substring(6,10));
                }
            }
        }
    }
    @Override
    public void addBooking(Booking booking) {
        bookingTreeSet.add(booking);
        bookingQueue.add(booking);
        WriteReadFileCSV.writeToFileBooking(WriteReadFileCSV.FILE_BOOKING, booking);
    }

    @Override
    public void displayBooking() {
        TreeSet<Booking> bookings = WriteReadFileCSV.readBookingCSV();
        for(Booking booking: bookings){
            System.out.println(booking.toString());
        }
    }
    public void displayBookingInYear(){
        for(Booking booking: bookingTreeSet){
            String[] birthdayArr = booking.getStartDay().split("/");
            int year = Integer.parseInt(birthdayArr[2]);
            System.out.println(booking.toString());
        }
    }
    public int numberUsingVilla(){
        int count = 0;
        TreeSet<Booking> bookings = WriteReadFileCSV.readBookingCSV();
        for (Booking booking: bookings) {
            if(booking.getNameOfService().equals("Villa")){
                count = count+1;
            }
        }
        return count;
    }
    public int numberUsingHouse(){
        int count = 0;
        for (Booking booking: WriteReadFileCSV.readBookingCSV()) {
            if(booking.getNameOfService().equals("House")){
                count = count+1;
            }
        }
        return count;
    }
    public int numberUsingRoom(){
        int count = 0;
        for (Booking booking: WriteReadFileCSV.readBookingCSV()) {
            if(booking.getNameOfService().equals("Room")){
                count = count+1;
            }
        }return count;
    }

    public void addNewContract(){
        Scanner input =new Scanner(System.in);
        for(Booking booking: BookingCheck.readBookingCSV()){
            int numberOfContract= 1;
            System.out.println("Contract ID: "+ numberOfContract);
            System.out.println("Booking ID: "+ booking.getBookingID());
            System.out.print("Money of deposit: ");
            long deposit = input.nextLong();
            System.out.print("Money of payment: ");
            long payment = input.nextLong();
            System.out.println("Customer ID: "+ booking.getCustomerID());
            WriteReadFileCSV.writeToFileContracts(WriteReadFileCSV.FILE_CONTRACT, new Contract(numberOfContract, booking.getBookingID(),deposit,payment, booking.getCustomerID()));
            numberOfContract++;
        }
    }
    public void displayContract() {
        for(Contract contract: WriteReadFileCSV.readContractCSV()){
            System.out.println(contract.toString());
        }
    }
    public void editContract(int id){
        Scanner input = new Scanner(System.in);
        for (Contract contract: contractTreeSet) {
            if(contract.getNumberContract() == id){
                System.out.print("Money of deposit: ");
                long deposit = input.nextLong();
                System.out.print("Money of payment: ");
                long payment = input.nextLong();
                contract.setDeposit(deposit);
                contract.setPayment(payment);
                break;
            }
        }
    }
}
