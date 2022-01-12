package ss10_dsa_list.thuc_hanh;


import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;//tang gap 2 kich thuoc
        elements = Arrays.copyOf(elements, newSize);
    }
//pt add
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++]=e;
    }
    //Phương thức get() trả về phần tử vừa ở vị trí thứ i trong danh sách.
    public E get(int i){
        if (i>=size||i<0){
            throw new IndexOutOfBoundsException("Index: "+i+", Size: "+i);
        }
        return (E) elements[i];
    }
}
