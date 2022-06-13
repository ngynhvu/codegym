package OOP.Bai_tap.StopWatch;

import java.util.Random;

public class SelectionSort {
    void sort(int arr[])
    {
        for (int i = 0; i < arr.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        StopWatch stopWatch = new StopWatch();
        int arr[] = new int[100000];

        for(int i=0; i<100000;i++){
            Random rand = new Random();
            int ranNum = rand.nextInt(100000)+1;
            arr[i] = ranNum;
        }

        stopWatch.start();
        s.sort(arr);
        System.out.println("after Selection Sort 100000 about: "+stopWatch.getElapsedTime()+" mili second");

    }
}
