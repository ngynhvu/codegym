package Stack_Queue.Bai_tap.Reverse;

import java.util.EmptyStackException;

public class Stack {
    private int size;
    private int top;
    private char[] a;
    public Stack(int n){
        top = - 1;
        size = n;
        a= new char[size];
    }
    public boolean isEmpty(){
        return (top<0);
    }

    public boolean push(char x)
    {
        if (top >= size)
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else
        {
            a[++top] = x;
            return true;
        }
    }

    //function to pop element from stack
    public char pop()
    {
        if (top < 0)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            char x = a[top--];
            return x;
        }
    }
}
