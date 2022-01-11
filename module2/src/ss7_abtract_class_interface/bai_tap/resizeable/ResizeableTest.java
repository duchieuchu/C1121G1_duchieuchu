package ss7_abtract_class_interface.bai_tap.resizeable;

import ss6_inheritance.thuc_hanh.Circle;
import ss6_inheritance.thuc_hanh.Rectangle;
import ss6_inheritance.thuc_hanh.Shape;
import ss6_inheritance.thuc_hanh.Square;

import java.util.Random;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape shape1 = new Circle(10); // ép kiểu ngầm định shape1 có kiểu dữ liệu tham chiếu
        Shape shape2 = new Square(10);
        Shape shape3 = new ss6_inheritance.thuc_hanh.Rectangle(3,2);
        Shape[] shapeList = {shape1, shape2, shape3};
        Random random = new Random();
        // Có thể dùng interface cho lớp Shape và sử dụng cơ chế Dynamic Byding để gọi resize lớp con mà ko cần ép kiểu;
        for (int i = 0; i < shapeList.length; i++) {
            if (shapeList[i] instanceof Circle) {
                System.out.println("Circle Area is:" + ((Circle) shapeList[i]).getArea());
                ((Circle) shapeList[i]).resize(random.nextDouble());
                System.out.println("Area after resize is:" + ((Circle) shapeList[i]).getArea());
            } else if (shapeList[i] instanceof Square) {
                System.out.println("Square Area is:" + ((Square) shapeList[i]).getArea());
                ((Square) shapeList[i]).resize(random.nextDouble());
                System.out.println("Area after resize is:" + ((Square) shapeList[i]).getArea());
            } else {
                System.out.println("Rectangle Area is:" + ((ss6_inheritance.thuc_hanh.Rectangle) shapeList[i]).getArea());
                ((ss6_inheritance.thuc_hanh.Rectangle) shapeList[i]).resize(random.nextDouble());
                System.out.println("Area after resize is:" + ((Rectangle) shapeList[i]).getArea());
            }
        }
    }
}
