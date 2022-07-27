package FuramaResort.Utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CMNDException extends Exception {
    static Scanner input = new Scanner(System.in);
    public CMNDException(String message){super(message);}
    public static String inputAndCheckId(){
        while (true){
            try {
                String cmnd = input.nextLine();
                Pattern pattern = Pattern.compile("\\d*");
                Matcher matcher = pattern.matcher(cmnd);
                if(matcher.matches()){
                    return cmnd;
                }else {
                    throw new IdFacillityException("Invalid ID!!! Please input again.");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
