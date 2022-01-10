package ss7_abtract_class_interface.thuc_hanh.comparator;

import ss6_inheritance.thuc_hanh.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius()> o2.getRadius())return 1;
        else if (o1.getRadius()<o2.getRadius())return -1;
        else return 0;
    }
}
