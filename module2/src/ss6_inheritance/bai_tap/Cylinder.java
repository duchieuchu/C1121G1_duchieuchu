package ss6_inheritance.bai_tap;

public class Cylinder extends Circle {
    double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Cylinder(double radius, double length, String color) {
        this.radius = radius;
        this.length = length;
        this.color = color;
    }

    public double getVolume() {
        return radius * radius * length * Math.PI;
    }

    @Override
    public String toString() {
        return "Cylinder{" + " radius= " + radius + " length= " + length +" color "+ color+'}'
                + " Volume: " + getVolume();
    }
}
