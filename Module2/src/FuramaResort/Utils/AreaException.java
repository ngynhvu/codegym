package FuramaResort.Utils;

import java.util.Scanner;

public class AreaException extends Exception{
    static Scanner input = new Scanner(System.in);
    public AreaException(String message){super(message);}
    public static double inputAndCheck(){
        while (true){
            try {
                double area = Double.parseDouble(input.nextLine());
                if(area>30){
                    return area;
                }else
                    throw new AreaException("Area not enough");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
