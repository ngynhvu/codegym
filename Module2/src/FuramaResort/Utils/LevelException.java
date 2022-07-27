package FuramaResort.Utils;

import java.util.Scanner;

public class LevelException extends Exception{
    static Scanner input = new Scanner(System.in);
    public LevelException(String message){super(message);}
    public static int inputAndCheck(){
        while (true){
            try {
                int choose = Integer.parseInt(input.nextLine());
                if(choose>0 && choose < 5){
                    return choose;
                }else
                    throw new LevelException("Please input again");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
