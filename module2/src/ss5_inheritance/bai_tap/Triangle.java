package ss5_inheritance.bai_tap;

public class Triangle {
    double slide1 = 1.0;
    double slide2 = 1.0;
    double slide3 = 1.0;
    String color;

    public Triangle() {
    }

    public Triangle(double slide1, double slide2, double slide3, String color) {
        this.slide1 = slide1;
        this.slide2 = slide2;
        this.slide3 = slide3;
        this.color = color;
    }

    public double getSlide1() {
        return slide1;
    }

    public void setSlide1(double slide1) {
        this.slide1 = slide1;
    }

    public double getSlide2() {
        return slide2;
    }

    public void setSlide2(double slide2) {
        this.slide2 = slide2;
    }

    public double getSlide3() {
        return slide3;
    }

    public void setSlide3(double slide3) {
        this.slide3 = slide3;
    }

    public double getArea() {
        double area = Math.sqrt(getP() / 2 * (getP() / 2 - slide1) * (getP() / 2 - slide2) * (getP() / 2 - slide3));
        return area;
    }

    public double getP() {
        return slide1 + slide2 + slide3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "slide1=" + slide1 +
                ", slide2=" + slide2 +
                ", slide3=" + slide3 +
                ", color='" + color + "}"+ ", Area: "+getArea()+", Perimeter: "+getP();
    }
}
