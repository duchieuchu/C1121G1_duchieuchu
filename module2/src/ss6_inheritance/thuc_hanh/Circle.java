package ss6_inheritance.thuc_hanh;

public class Circle extends Shape {
    double radius = 1.0;

    public Circle() {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }

    public double getPerimeter() {
        return radius*2*Math.PI;
    }
    public String toString(){
        return "A circle with radius "+getRadius()
                +", which is a subclass of "+super.toString();
//                +" Area: "+getArea()
//                +" Perimeter: "+getPerimeter();
    }
}
