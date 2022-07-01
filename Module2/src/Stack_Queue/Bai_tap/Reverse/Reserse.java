package Stack_Queue.Bai_tap.Reverse;

public class Reserse {
    public static void reverse(StringBuffer str){
        int n = str.length();
        Stack obj = new Stack(n);
        for (int i = 0; i < n; i++)
            obj.push(str.charAt(i));
        for (int i = 0; i < n; i++)
        {
            char ch = obj.pop();
            str.setCharAt(i,ch);
        }
    }
    public static void main(String[] args) {
        StringBuffer s= new StringBuffer("12345567");
        reverse(s);
        //print the reversed string
        System.out.println("Reversed string is " + s);
    }
}
