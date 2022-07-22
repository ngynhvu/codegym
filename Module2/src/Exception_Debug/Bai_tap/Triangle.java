package Exception_Debug.Bai_tap;

import java.util.Scanner;

public class Triangle {
    public Triangle(int a, int b, int c) throws IllegalTriangleException {
        if(a>b+c||b>a+c||c>a+b||a>0 && b>0&&c>0){
            throw new IllegalTriangleException("Not triangle");
        }
        System.out.println("That is a triangle");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCheck = false;
        while (!isCheck){
            try {
                System.out.println("Enter a: ");
                int a  = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter b: ");
                int b  = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter c: ");
                int c  = Integer.parseInt(scanner.nextLine());
                Triangle triangle = new Triangle(a,b,c);
                isCheck = true;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
