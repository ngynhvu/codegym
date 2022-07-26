package FuramaResort.Utils;

import java.util.Scanner;

public class ChooseException extends Exception{
    static Scanner input = new Scanner(System.in);
    public ChooseException(String message){super(message);}
    public static int inputAndCheck(){
        while (true){
            try {
                int choose = Integer.parseInt(input.nextLine());
                if(choose>0&& choose<6){
                    return choose;
                }else
                    throw new ChooseException("Your choose not have my type of customer");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
