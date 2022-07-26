package FuramaResort.Utils;

import java.util.Scanner;

public class GenderException extends Exception{
    static Scanner input = new Scanner(System.in);
    public GenderException(String message){super(message);}
    public static String inputAndCheck(){
        while (true){
            try {
                int choose = Integer.parseInt(input.nextLine());
                if(choose == 1){
                    return "Male";
                }else if(choose ==2){
                    return "Female";
                }else if(choose == 3){
                    return "Other";
                }
                else
                    throw new ChooseException("Your choose not have my type of customer");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
