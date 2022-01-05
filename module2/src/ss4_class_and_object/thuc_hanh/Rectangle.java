package ss4_class_and_object.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width:");
        double width = scanner.nextDouble();
        System.out.println("Enter height:");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Your rectangle: "+rectangle.display());
        System.out.println("Area of the rectangle: "+rectangle.getArea());
        System.out.println("Perimeter of the rectangle: "+rectangle.getPerimeter());


    }

    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return  "width" + width + " " + "height" + height;
    }
}
