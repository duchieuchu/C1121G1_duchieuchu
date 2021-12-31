package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class DrawMenu {
    public static void main(String[] agrs) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1 tam giac ");
            System.out.println("2 hinh chu nhat");
            System.out.println("3 hinh vuong");
            System.out.println("0 exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("****");
                    System.out.println("****");
                    System.out.println("****");
                    break;
                case 3:
                    System.out.println("*******");
                    System.out.println("*******");
                    System.out.println("*******");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice");
            }
        }
    }
}
