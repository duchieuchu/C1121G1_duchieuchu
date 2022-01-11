package ss7_abtract_class_interface.bai_tap.colorable;

import ss6_inheritance.thuc_hanh.Circle;
import ss6_inheritance.thuc_hanh.Rectangle;
import ss6_inheritance.thuc_hanh.Shape;
import ss6_inheritance.thuc_hanh.Square;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[10];
        shapeList[0] = new Circle(10);
        shapeList[1] = new Rectangle(10, 20);
        shapeList[2] = new Square(10);
        shapeList[3] = new Circle(20);
        for (int i = 0; i < shapeList.length; i++) {
            if (shapeList[i] != null) {
                if (shapeList[i] instanceof Circle) {
                    System.out.println("Area of " + shapeList[i] + " is " + ((Circle) shapeList[i]).getArea());
                } else if (shapeList[i] instanceof Square) {
                    System.out.println("Area of " + shapeList[i] + " is " + ((Square) shapeList[i]).getArea());
                    ((Square) shapeList[i]).howToColor();
                } else {
                    System.out.println("Area of " + shapeList[i] + " is " + ((Rectangle) shapeList[i]).getArea());
                }
            } else {
                break;
            }
        }

    }
}
