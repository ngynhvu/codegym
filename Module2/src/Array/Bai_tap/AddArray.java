package Array.Bai_tap;

import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        int[] array = {3,5,24,5,6,87,0,0,0,0};
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập phần tử thêm vào: ");
        int valueInsert = input.nextInt();

        System.out.print("Nhập vị trí thêm vào trong mảng: ");
        int indexInsert = input.nextInt();

        if(indexInsert <= -1 && indexInsert >= array.length-1){
            System.out.println("Vị trí kh hợp lệ");
        }else{
            for(int index = array.length-1; index > indexInsert; index--){
                array[index] = array[index-1];
            }

            array[indexInsert] = valueInsert;

            for (int value : array){
                System.out.print(value+ " ");
            }
        }
    }
}
