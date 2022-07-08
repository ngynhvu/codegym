package Stack_Queue.Bai_tap.Queue;

import java.util.EmptyStackException;

public class Solution {
    private Node front;
    private Node rear;
    private int numbNodes;
    public class Node{
        private int data;
        private Node link;
        public Node(int data){
            this.data = data;
        }
        public int getData(){
            return this.data;
        }
    }
    public void enQueue(int data){
        Node temp = new Node(data);
        if(front == null){
            front = rear = temp;
            numbNodes++;
        }else{
            rear.link = temp;
            rear = temp;
            rear.link = front;
            numbNodes++;
        }
    }

    public void deQueue(){
        if(front == null){
            throw new EmptyStackException();
        }else if(front == rear){
            front = rear = null;
            numbNodes--;
        }else{
            front = front.link;
            rear.link = front;
            numbNodes--;
        }
    }

    public void displayQueue(){
        if(front == null){
            System.out.println("Empty");
        }else{
            Node temp = front;
            for(int i = 0;  i<numbNodes; i++){
                System.out.println(temp.getData());
                temp= temp.link;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.enQueue(3);
        solution.enQueue(23);
        solution.enQueue(31);
        solution.deQueue();
        solution.enQueue(314);
        solution.enQueue(213);
        solution.deQueue();
        solution.deQueue();
        solution.deQueue();
        solution.displayQueue();
    }
}
