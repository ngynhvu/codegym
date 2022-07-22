package FuramaResort.Utils;

import java.util.Scanner;

public class LimitPeopleException extends Exception {
    static Scanner input = new Scanner(System.in);
    LimitPeopleException(String s){super(s);}
    public static int inputAndCheckLimitPeople(){
        while (true){
            try {
                System.out.print("Limit people of service: ");
                int people = Integer.parseInt(input.nextLine());
                if(people<0){
                    throw new LimitPeopleException("Number of people not be more than 0");
                }else if(people >20){
                    throw new LimitPeopleException("Number of people should not be more than 20");
                }else {
                    return people;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
