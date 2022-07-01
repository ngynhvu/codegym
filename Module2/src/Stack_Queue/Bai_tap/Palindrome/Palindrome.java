package Stack_Queue.Bai_tap.Palindrome;

import Stack_Queue.Bai_tap.Queue.Solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input here: ");
        String inputString = scanner.nextLine();
        Queue queue = new LinkedList();
        for (int i = inputString.length()-1; i >=0; i--) {
            queue.add(inputString.charAt(i));
        }
        String reverseString ="";
        while (!queue.isEmpty()){
            reverseString =reverseString + queue.remove();
        }
        if(inputString.equals(reverseString)){
            System.out.println("It's a palindrome");
        }else
            System.out.println("It's not a palindrome");
    }
}
