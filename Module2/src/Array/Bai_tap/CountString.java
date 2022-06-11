package Array.Bai_tap;

import java.util.Scanner;

public class CountString {
    public static void main(String[] args) {
        String str = "hoang tien anh";
        int count = 0;
        String word;
        System.out.print("Nhập từ cần đếm trong chuỗi: ");
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();

        for(int i = 0; i < str.length(); i++){
            char wordInStr = str.charAt(i);
            if(Character.toString(wordInStr).equals(word)){
                count++;
            }
        }

        System.out.printf("Số từ %s có trong chuỗi là %d",word,count);
    }
}
