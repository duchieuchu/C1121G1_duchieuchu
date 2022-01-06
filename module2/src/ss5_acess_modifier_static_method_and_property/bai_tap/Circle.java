package ss5_acess_modifier_static_method_and_property.bai_tap;

public class Circle {
    double radius = 1.0;
    String color = "red";
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return radius * radius * 3.14;
    }
}
