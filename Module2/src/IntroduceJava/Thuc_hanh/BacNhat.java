package IntroduceJava;

import java.util.Scanner;

public class BacNhat {
    public static void main(String[] args) {
        double a, b,c,  x;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        a = scanner.nextDouble();
        System.out.print("Enter b: ");
        b = scanner.nextDouble();
        System.out.print("Enter c: ");
        c = scanner.nextDouble();
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
