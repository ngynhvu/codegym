package Bai_Tap;

public class demo {
    public static void main(String[] args) {
        int h =6;
        for (int i = 1; i<= h; i++){
            for(int j = h; j >= i; j--){
                System.out.print(" ");
            }
            for(int j = 1; j<=i;j++){
                System.out.print("*");
            }
                System.out.println();
        }
    }
}
