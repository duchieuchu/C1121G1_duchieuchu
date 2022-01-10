package ss7_abtract_class_interface.thuc_hanh.comparable;


import ss6_inheritance.thuc_hanh.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle(){}
    public ComparableCircle(double radius){
        super(radius);
    }

    public ComparableCircle(double radius,String color,boolean filed){
        super(radius,color,filed);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius()>o.getRadius())return 1;
        else if (getRadius()<o.getRadius())return -1;
        else return 1;
    }
}
