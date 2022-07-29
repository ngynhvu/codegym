package FuramaResort.Models;

import java.util.Comparator;
import java.util.Date;

public class Booking {
    private int bookingID;
    private String startDay;
    private String endDay;
    private int customerID;
    private String nameOfService;
    private String typeOfService;

    public Booking(int bookingID, String startDay, String endDay, int customerID, String nameOfService, String typeOfService) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerID = customerID;
        this.nameOfService = nameOfService;
        this.typeOfService = typeOfService;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customerID=" + customerID +
                ", nameOfService='" + nameOfService + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }
    public String simpleString(){
        return bookingID+","+startDay+","+endDay+","+customerID+","+nameOfService+","+typeOfService;
    }
}
