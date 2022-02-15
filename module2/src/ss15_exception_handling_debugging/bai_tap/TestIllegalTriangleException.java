package ss15_exception_handling_debugging.bai_tap;

import java.util.Scanner;

public class TestIllegalTriangleException {
    public static void checkSideTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 | side2 <= 0 | side3 <= 0) {
            throw new IllegalTriangleException("side must be greater than 0!!! ");
        }
        if (side1 + side2 <= side3 | side1 + side3 <= side2 | side2 + side3 <= side1)
            throw new IllegalTriangleException("sum of 2 sides is not greater than the other side!!!");
    }

    public static void main(String[] args) throws IllegalTriangleException {
        boolean flag;
        do {
            flag = false;
            Scanner scanner = new Scanner(System.in);
            System.out.print("enter side 1: ");
            double side1 = Double.parseDouble(scanner.nextLine());
            System.out.print("enter side 2: ");
            double side2 = Double.parseDouble(scanner.nextLine());
            System.out.print("enter side 3: ");
            double side3 = Double.parseDouble(scanner.nextLine());
            try {
                checkSideTriangle(side1, side2, side3);
                System.out.println("3 sides in triangle is: side1= " + side1 + ", side 2= " + side2 + ", side 3= " + side3);
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        } while (flag);

    }
}
