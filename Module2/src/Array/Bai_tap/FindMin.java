package Array.Bai_tap;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i= 0; i<array.length; i++){
            System.out.printf("array[%d] = ",i);
            int value = input.nextInt();
            array[i] = value;
        }

        int min = array[0];
        for(int i = 0; i<array.length; i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        System.out.println("Min in array: " + min);
    }
}
