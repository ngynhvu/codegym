package FuramaResort.Utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdFacillityException extends Exception {
    static Scanner input = new Scanner(System.in);
    public IdFacillityException(String message){super(message);}
    public static String inputAndCheckId(){
        while (true){
            try {
                String idNumber = input.nextLine();
                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(idNumber);
                if(matcher.matches() && idNumber.length() == 4){
                    return idNumber;
                }else {
                    throw new IdFacillityException("Invalid ID!!! Please input again.");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
