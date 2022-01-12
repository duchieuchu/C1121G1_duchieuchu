package ss10_dsa_list.bai_tap;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    Object elements[];
    private MyList<E> newList;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }


    public void add(int index, E element) {
        if (index > size) {
            ensureCapacity(size);
        }
        this.elements[size++] = elements;

    }

    public E remove(int index) {
        for (int i = index; i < DEFAULT_CAPACITY; i++) {
            if (i < size) {
                elements[i] = elements[i + 1];
            } else {
                elements[i] = null;
            }
        }
        size--;
        return (E) this.elements;
    }

    public int size() {
        return this.size;
    }

    public MyList<E> clone() {
        for (int i = 0; i < this.size; i++) {
            newList.add((E) this.elements[i]);
        }
        return newList;
    }

    public boolean contains(E object) {
        boolean check = true;
        for (int i = 0; i <= size; i++) {
            if (elements[i].equals(object)) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if (check) {
            return true;
        }
        return false;
    }

    public int indexOf(E object) {
        int index = 0;
        for (int i = 0; i <= size; i++) {
            if (elements[i].equals(object)) {
                index = i;
                break;
            }
        }
        if (index != 0) {
            return index;
        }
        return -1;
    }

    public boolean add(E elements) {
        this.elements[size++] = elements;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + i);
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
            size = 0;
        }
    }

}
