package ss6_inheritance.thuc_hanh;

import ss7_abtract_class_interface.bai_tap.colorable.Colorable;
import ss7_abtract_class_interface.bai_tap.resizeable.Resizeable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side,side);
    }
    public Square(double side,String color,boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "A Square with side= "+getSide()+", Which of a subclass of"+super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(getLength()*percent);
        setSide(getWidth()*percent);

    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
