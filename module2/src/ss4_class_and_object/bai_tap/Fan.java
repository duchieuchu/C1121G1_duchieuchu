package ss4_class_and_object.bai_tap;

import java.util.Scanner;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {

    }

    public String toString() {
        if (this.on) {
            return "Fan is on." + "\nspeed: " + this.speed + "\ncolor: " + this.color + "\nradius :" + this.radius;
        } else {
            return "Fan is off." + "\nspeed: " + this.speed + "\ncolor: " + this.color + "\nradius :" + this.radius;
        }
    }

    public static void main(String[] args) {
        System.out.println("Fan1");
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        System.out.println(fan1.toString());

        System.out.println("\nFan2");
        Fan fan2 = new Fan();
        fan2.setOn(false);
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        System.out.println(fan2.toString());
    }
}


