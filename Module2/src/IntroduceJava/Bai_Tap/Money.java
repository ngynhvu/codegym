package IntroduceJava.Bai_Tap;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter money here USD");
        long usd = input.nextLong();
        long vnd = usd*23000;
        System.out.println(vnd);
    }
}
