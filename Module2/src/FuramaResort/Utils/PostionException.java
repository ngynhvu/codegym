package FuramaResort.Utils;

import java.util.Scanner;

public class PostionException extends Exception {
    static Scanner input = new Scanner(System.in);
    public PostionException(String message){super(message);}
    public static int inputAndCheck(){
        while (true){
            try {
                int choose = Integer.parseInt(input.nextLine());
                if(choose>0 && choose < 7){
                    return choose;
                }else
                    throw new LevelException("Please input again");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
