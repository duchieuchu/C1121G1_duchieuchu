package ss11_dsa_stack_queue.thuc_hanh;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args) {
        Queue<String> myQueue = new LinkedList<>();
        myQueue.add("a,b");
        myQueue.offer("b,d");
        myQueue.offer("e,f");
        myQueue.offer("g,h");


//        System.out.println(myQueue.peek());//show pt dau
//        System.out.println(myQueue.element());

//        System.out.println(myQueue.poll());//xoa pt dau
//        System.out.println(myQueue.remove());
//        myQueue.clear();//xoa all pt

//        System.out.println(myQueue.isEmpty());//kiem tra co rong ko

//        System.out.println(myQueue.contains("a,b"));//kiem tra pt co trong hang doi chua
        System.out.println(myQueue.size());//kich thuoc cua queue

        //duyet cac pt ben trong hang doi
        for (String element : myQueue) {
            System.out.println(element);
        }
//        for (Object element : myQueue) {
//            System.out.println(element + "\t");
//        }

        //duyet = iterator
        Iterator<String> iterator = myQueue.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }


    }
}
