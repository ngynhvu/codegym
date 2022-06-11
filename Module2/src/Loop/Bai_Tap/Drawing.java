package Bai_Tap;

import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter height: ");
                    int a = input.nextInt();
                    System.out.println("Enter width: ");
                    int b = input.nextInt();
                    for (int i = 1; i<= a; i++){
                        for(int j = 1; j<=b; j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    int c = -1;
                    while (c !=0){
                        System.out.println("1. top-left");
                        System.out.println("2. top-right");
                        System.out.println("3. botton-left");
                        System.out.println("4. botton-right");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");
                        c = input.nextInt();
                        System.out.println("Enter height of triangle: ");
                        int h = input.nextInt();

                        switch (c){
                            case 1:
                                for (int i = 1; i<= h; i++){
                                    for(int j = h; j >= i; j--){
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 2:
                                for (int i = 1; i<= h; i++){
                                    for(int j = h; j >= i; j--){
                                        System.out.print(" ");
                                    }
                                    for(int j = 1; j<=i;j++){
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 3:
                                for (int i = 1; i<= h; i++){
                                    for(int j = 1; j < i; j++){
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 4:
                                for (int i = 1; i<= h; i++){
                                    for(int j = h; j >= i; j--){
                                        System.out.print(" ");
                                    }
                                    for (int j = 1; j<=i;j++){
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 0:

                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter height of triangle: ");
                    int h = input.nextInt();
                    for(int i =1; i<=h;i++){
                        for(int j = 1;j<=h-i; j++){
                            System.out.print(" ");
                        }
                        for (int j =1; j<= 2*i - 1; j++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
