package Array.Bai_tap;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter row");
        int row = input.nextInt();
        System.out.print("Enter col");
        int col = input.nextInt();
        int[][] arrMatrix = new int[row][col];

        for (int i = 0; i<arrMatrix.length; i++){
            for(int j =0; j<arrMatrix[i].length; j++){
                System.out.printf("Enter value arrMatrix[%d][%d] = ", i, j);
                int value = input.nextInt();
                arrMatrix[i][j] = value;
            }
        }
        int sum =0;
        for(int i = 0; i < arrMatrix.length; i++){
            for (int j = 0; j < arrMatrix[i].length; j++){
                if(i == j){
                    sum += arrMatrix[i][j];
                    break;
                }
            }
        }

        System.out.println("Diagonal Line of Array is: "+sum);
    }
}
