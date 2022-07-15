package FuramaResort.Services.Interface;

import FuramaResort.Models.Booking;

public interface BookingService extends Service{
    void addBooking(Booking booking);
    void displayBooking();
}
