package FuramaResort.Utils;

import java.util.Scanner;

public class PositiveException extends Exception{
    static Scanner input = new Scanner(System.in);
    public PositiveException(String message){
        super(message);
    }
    public static int inputAndCheckPositive(){
        while (true){
            try {
                int floors = Integer.parseInt(input.nextLine());
                if(floors >0){
                    return floors;
                }else
                    throw new PositiveException("Floor must to position");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
