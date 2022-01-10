package ss7_abtract_class_interface.thuc_hanh.comparator;

import ss6_inheritance.thuc_hanh.Circle;

import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle []circles=new Circle[3];
        circles[0]=new Circle(3.6);
        circles[1]=new Circle(2);
        circles[2]= new Circle(3.5,"indigo",false);
        System.out.println("Pre-sorted");//truoc
        for (Circle circle:circles) {
            System.out.println(circle);
        }
        //sau
        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles,circleComparator);
        System.out.println("after-sorted:");
        for (Circle circle:circles
             ) {
            System.out.println(circle);

        }
    }

}
