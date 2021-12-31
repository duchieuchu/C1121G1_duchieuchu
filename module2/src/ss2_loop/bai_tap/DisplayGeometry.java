package ss2_loop.bai_tap;

import java.util.Scanner;

public class DisplayGeometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu: ");
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle1");
            System.out.println("3.Print the square triangle1");
            System.out.println("4.Print the isosceles triangle");
            System.out.println("5.Exit");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        System.out.println("*************");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 7; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("*");
                    }
                    break;
                case 3:
                    for (int i = 7; i > 0; i--) {
                        for (int j = 0; j < i-1; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("*");
                    }
                    break;
                case 5:
                    System.exit(5);
                default:
                    System.out.println("No choice");
            }
        }
    }
}
