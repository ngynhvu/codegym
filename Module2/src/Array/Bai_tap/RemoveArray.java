package Array.Bai_tap;

import java.util.Scanner;

public class RemoveArray {
    public static void main(String[] args) {
        int[] array = {3,5,24,5,6,87};

        System.out.print("Xóa phần tử X : ");
        Scanner inputDel = new Scanner(System.in);
        int remove = inputDel.nextInt();

        for(int index= 0; index < array.length; index++ ){
            if(array[index] == remove){
                for(int i = index; i < array.length; i++){
                    if(i == array.length-1){
                        array[i] = 0;
                        continue;
                    }
                    array[i] = array[i+1];
                }
            }
        }

        for (int value : array){
            System.out.print(value);
        }

    }
}
