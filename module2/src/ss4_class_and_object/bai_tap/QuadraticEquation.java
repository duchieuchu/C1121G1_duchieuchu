package ss4_class_and_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;

    }
    public double getDetla() {
        return b * 2 - 4 * a * c;
    }

    public double getRoot1() {
        return (-b + Math.sqrt(b * 2 - 4 * a * c)) / 2 * a;
    }

    public double getRoot2() {
        return (-b - Math.sqrt(b * 2 - 4 * a * c)) / 2 * a;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a:");
        double a = scanner.nextDouble();
        System.out.println("Enter b:");
        double b = scanner.nextDouble();
        System.out.println("Enter c:");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDetla() > 0) {
            System.out.println("The equation has 2 root");
            System.out.println("r1= " + quadraticEquation.getRoot1());
            System.out.println("r2= " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDetla() == 0) {
            System.out.println("The equation has 1 root");
            System.out.println("r= " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }

}
