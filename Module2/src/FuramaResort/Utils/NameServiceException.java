package FuramaResort.Utils;

import java.util.Scanner;

public class NameServiceException extends Exception{
    static Scanner input = new Scanner(System.in);
    public NameServiceException(String message){super(message);}
    public static String inputAndCheck(){
        while (true){
            try {
                int choose = Integer.parseInt(input.nextLine());
                if(choose == 1){
                    return "Villa";
                }else if(choose ==2){
                    return "House";
                }else if(choose == 3){
                    return "Room";
                }
                else
                    throw new ChooseException("Your choose not have my type of name service");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
