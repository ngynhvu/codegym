package Array.Bai_tap;

import java.util.Scanner;

public class SumArray {
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
        System.out.printf("Sum in row: ");
        int inputRow = input.nextInt();
        for (int i = 0; i < arrMatrix[inputRow].length; i++) {
            sum = sum + arrMatrix[inputRow][i];
        }
        System.out.printf("Sum in row %d: %d",inputRow, sum);
    }
}
