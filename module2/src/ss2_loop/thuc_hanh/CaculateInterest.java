package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class CaculateInterest {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        double totalInterest = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("so tien gui");
        money = input.nextDouble();
        System.out.println("so thang gui");
        month = input.nextInt();
        System.out.println("ti le lai suat /nam");
        interestRate = input.nextDouble();

        totalInterest += money * (interestRate / 100) / 12 * month;
        System.out.println("tien lai: " + totalInterest);
    }
}
