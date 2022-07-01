package FuramaResort.Models;

import java.util.Date;

public class Booking {
    private String bookingID;
    private Date startDay;
    private Date endDay;
    private String nameOfService;
    private String typeOfService;

    public Booking(String bookingID, Date startDay, Date endDay, String nameOfService, String typeOfService) {
        this.bookingID = bookingID;
        this.startDay = startDay;
        this.endDay = endDay;
        this.nameOfService = nameOfService;
        this.typeOfService = typeOfService;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
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
}
