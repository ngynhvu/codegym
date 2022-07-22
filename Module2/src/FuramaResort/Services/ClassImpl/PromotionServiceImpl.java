package FuramaResort.Services.ClassImpl;

import FuramaResort.Services.Interface.PromotionService;

import java.util.TreeSet;

public class PromotionServiceImpl implements PromotionService {
    private static TreeSet<Integer> listCustomerService = new TreeSet<>();
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    @Override
    public void displayUseService() {
        bookingService.displayUsingService();
    }

    @Override
    public void displayGetVoucher() {

    }
}
