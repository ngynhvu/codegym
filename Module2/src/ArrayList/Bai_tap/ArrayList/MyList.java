package ArrayList.Bai_tap.ArrayList;

import java.util.EventListener;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }
    public void add(int index, E element){
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = element;
        size++;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

    public E remove(int index){
        checkIndex(index);

        E e = (E) elements[index];

        // Shift data to the left
        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];

        elements[size - 1] = null; // This element is now null

        // Decrement size
        size--;
        return e;
    }
    public int size(){
        return size;
    }
    public E clone(){
        MyList<E> clone = new MyList<>(elements.length);
        for (Object x : elements) {
//            clone.add((E) x);
        }
        return (E) clone;
    }


    public boolean contains(E o){
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i]))
                return true;
        return false;
    }
    public int indexOf(E o){
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i])) return i;
        return -1;
    }
    public boolean add(E e){
        elements = new Object[DEFAULT_CAPACITY+1];
        elements[DEFAULT_CAPACITY+1] = e;
        return true;
    }
    private void ensureCapacity() {
        if (size >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
        }
    }
    public E get(int i){
        checkIndex(i);
        return (E) elements[i];
    }
    public void clear(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
