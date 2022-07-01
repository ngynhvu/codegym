package ArrayList.Bai_tap.LinkedList;

import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes = 0;

    public class Node {
        private Node next;

        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public MyLinkedList(Object o){
        head = new Node(o);
    }
    public void add(int index, E element) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(E e){
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E e){
        Node temp = head;
        for(int i =0; i < numNodes; i++){
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public boolean remove(E e){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(e)) {
                remove(i);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void remove(int index){
        Node temp = head;
        Node holder =null;

        if(index == 0){
            holder = temp.next;
            head = holder;
            numNodes--;
        }else if(index == numNodes){
            for(int i =0; i< index-1; i++){
                temp = temp.next;
            }
            temp.next = null;
            numNodes--;
        }else{
            for(int i =0; i< index-2; i++){
                temp = temp.next;
            }
            holder = temp.next.next;
            temp.next = holder;
            numNodes --;
        }
    }
    public int size(){
        return numNodes;
    }
//    public Node clone(){
//
//    }
    public boolean contains(E o){
        Node temp = head;
        boolean check = false;
        for(int i =0; i< numNodes; i++){
            if(temp.getData().equals(o)){
                check = true;
                break;
            }
            temp=temp.next;
        }
        return check;
    }
    public int indexOf(E o){
        Node previous = head;
        int loction = -1;
        for(int i = 0; i<numNodes;i++){
            if(previous.equals(o)){
                loction = i;
                break;
            }
            previous = previous.next;
        }
        return loction;
    }
    public boolean add(E e){
        tail.next = new Node(e);
        tail = tail.next;
        return true;
    }
    public void ensureCapacity(int minCapacity){

    }
    public Node get(int index){
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public Node getFirst(){
        return head;
    }
    public Node getLast(){
        return tail;
    }
    public void clear(){
        head = null;
    }

}
