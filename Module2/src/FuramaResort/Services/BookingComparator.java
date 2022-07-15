package FuramaResort.Services;

import FuramaResort.Models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if(o1.getStartDay().compareTo(o2.getStartDay())> 0){
            return 1;
        }else if(o1.getStartDay().compareTo(o2.getStartDay()) == 0){
            if(o1.getEndDay().compareTo(o2.getEndDay())> 0){
                return 1;
            }else if(o1.getEndDay().compareTo(o2.getEndDay())==0){
                return 0;
            }
            return -1;
        }return -1;
    }
}
