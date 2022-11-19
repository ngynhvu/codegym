package FinalExam.Utils;

import FuramaResort.Utils.IdFacillityException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDExcepion extends Exception {
    static Scanner input = new Scanner(System.in);
    public IDExcepion(String message){super(message);}
    public static String inputAndCheckId(){
        while (true){
            try {
                System.out.print("Ma san pham: SP");
                String idNumber = input.nextLine();
                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(idNumber);
                if(matcher.matches() && idNumber.length() == 5){
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
