package FinalExam.Utils;

import FuramaResort.Utils.IdFacillityException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckException extends Exception{
    static Scanner input = new Scanner(System.in);
    public CheckException(String message){super(message);}
    public static long price(){
        while (true){
            try {
                long price = Long.parseLong(input.nextLine());
                if(price >0){
                    return price;
                }else {
                    throw new CheckException("Please input again.");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static int soluong(){
        while (true){
            try {
                int soluong = Integer.parseInt(input.nextLine());
                if(soluong >0){
                    return soluong;
                }else {
                    throw new CheckException("Please input again.");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
