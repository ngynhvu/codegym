package Stack_Queue.Bai_tap.BStack;

import java.util.Stack;

public class BStack {
    static boolean isPair(char character1, char character2){
        if(character1 == '(' && character2 == ')')
            return true;

        else if(character1 == '{' && character2 == '}')
            return true;

        else if(character1 == '[' && character2 == ']')
            return true;

        else
            return false;
    }

    static boolean isBalanced(char s[]){
        Stack st=new Stack();

        for(int i=0;i<s.length;i++){

            if(s[i] == '{' || s[i] == '(' || s[i] == '[')
                st.push(s[i]);

            if(s[i] == '}' || s[i] == ')' || s[i] == ']'){

                if (st.isEmpty()){
                    return false;
                }

                else if( !isPair((Character) st.pop(), s[i])){
                    return false;
                }
            }

        }

        if(st.isEmpty())
            return true;

        else
            return false;
    }
    public static void main(String[] args) {
        char s[] = {'[','(',')',']','{','}','{','[','(',')','(',')',']','(',')','}'};

        if(isBalanced(s)){
            System.out.println("Expression is balanced.");
        }

        else{
            System.out.println("Expression is not balanced.");
        }
    }
}
