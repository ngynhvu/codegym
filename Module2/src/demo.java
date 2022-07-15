import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
        if(startDay.compareTo(endDay) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if(startDay.compareTo(endDay) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if(startDay.compareTo(endDay) == 0) {
            System.out.println("Both dates are equal");
        }
    }
}
