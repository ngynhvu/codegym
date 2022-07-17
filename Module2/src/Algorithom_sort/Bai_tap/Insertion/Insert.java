package Algorithom_sort.Bai_tap.Insertion;

import java.util.Arrays;

public class Insert {
    static int[] list = {3,2,32,34,23,21,11,32};

    public static void insertionSort(int[] list){

        for(int i =1; i< list.length; i++){
            System.out.println("Bước "+i+" gán x = list["+i+"] = "+list[i]+" pos= "+i);
            int pos = i;
            int x = list[i];
            System.out.println("Tiếp theo nếu x < list[post -1]");
            while (pos > 0 && x < list[pos -1]){
                System.out.println("Đổi chổ cho list["+pos+"] và list["+(pos-1)+"]");
                list[pos ]=list[pos-1];
                pos--;
            }
            System.out.println("Gán lai list["+pos+"]= "+x );
            list[pos] =x;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
