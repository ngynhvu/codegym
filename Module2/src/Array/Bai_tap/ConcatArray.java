package Array.Bai_tap;

import java.util.Scanner;

public class ConcatArray {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[4];
        int[] arr = new int[arr1.length+arr2.length];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i<arr1.length; i++){
            System.out.printf("Mảng 1: nhập vị trí thứ %d: ", i);
            int value = input.nextInt();
            arr1[i] = value;
        }
        for(int i = 0; i<arr2.length; i++){
            System.out.printf("Mảng 2: nhập vị trí thứ %d: ", i);
            int value = input.nextInt();
            arr2[i] = value;
        }
        for(int i =0; i<arr1.length; i++){
            arr[i] = arr1[i];
        }
        for (int i =0; i<arr2.length; i++){
            arr[arr1.length+ i] = arr2[i];
        }
        for (int value:arr) {
            System.out.println(value);
        }

    }
}
