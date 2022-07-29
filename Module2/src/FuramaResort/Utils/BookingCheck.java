package FuramaResort.Utils;

import FuramaResort.Models.Booking;
import FuramaResort.Services.BookingComparator;
import FuramaResort.Services.WriteReadFileCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class BookingCheck {
    public static Queue<Booking> readBookingCSV() {
        Queue<Booking> bookings = new LinkedList<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(WriteReadFileCSV.FILE_BOOKING);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Booking booking;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String startDay = temp[1];
                String endDay = temp[2];
                int customerID = Integer.parseInt(temp[3]);
                String nameService = temp[4];
                String type = temp[5];
                booking = new Booking(id,startDay,endDay,customerID,nameService,type);
                bookings.add(booking);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return bookings;
    }
}
