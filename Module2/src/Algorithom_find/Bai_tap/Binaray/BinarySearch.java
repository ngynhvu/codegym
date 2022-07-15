package Algorithom_find.Bai_tap.Binaray;

public class BinarySearch {
    public static int binarySearch(int[] array, int left, int right, int value){
        while (left<=right){
            int mid = (left+right)/2;
            if(array[mid] == value){
                return mid;
            }else if(array[mid]>value){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array ={1,2,3,4,5,6,7,8,9,10,12,15};
        System.out.println(binarySearch(array,array[0],array[array.length -1], 3));
    }
}
