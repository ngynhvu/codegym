package Stack_Queue.Bai_tap.Binary;

import java.util.Scanner;
import java.util.Stack;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Enter number here: ");
        int number = scanner.nextInt();
        while (number!=0){
            int d = number%2;
            stack.push(d);
            number =number/2;
        }
        System.out.print("\nGiá trị nhị phân là: ");
        while (!(stack.isEmpty() ))
        {
            System.out.print(stack.pop());
        }
    }
}
