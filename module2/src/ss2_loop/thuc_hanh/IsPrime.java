package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.println("is NOT prime");
        } else {
            int i = 2;
            boolean check = true;
            while (i <=Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.println("is prime");
            } else {
                System.out.println("is NOT prime");
            }
        }
    }
}
