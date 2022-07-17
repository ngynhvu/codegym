package Algorithom_sort.Bai_tap.InsertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array){
        for(int i = 0; i<array.length -1; i++){
            int minValue = array[i];
            int minIndex =i;
            for (int j = i+1; j <array.length ; j++) {
                if(minValue >array[j]){
                    minValue=array[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                int temp =array[i];
                array[i] = minValue;
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3,5,3,24,5,425,53,43,23,12};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
