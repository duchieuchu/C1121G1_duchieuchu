package ss11_dsa_stack_queue.thuc_hanh;

import java.util.Iterator;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer>myStack=new Stack<>();
        myStack.push(1);//them pt o dau stack
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
//        System.out.println(myStack.peek());// pt o dau stack
//        System.out.println("size: "+myStack.size());//kich thuoc cua stack
//        System.out.println(myStack.pop());//xoa pt dau stack
//        System.out.println(myStack.peek());
//        System.out.println(myStack.search(5));//hien thi pt o vi tri can tim
        //duyet phan tu
//        Iterator<Integer> iterator=myStack.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next()+"\t");
//        }
        for (Integer element:myStack
             ) {
            System.out.print(element+"\t");

        }
    }
}
