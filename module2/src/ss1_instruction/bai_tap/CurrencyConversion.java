package ss1_instruction.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double usd;
        double vnd;
        System.out.println("Enter USD");
        usd = scanner.nextDouble();
        double quidoi = usd * 23000;
        System.out.println("VND: " + quidoi);

        System.out.println("Enter VND");
        vnd = scanner.nextDouble();
        double quidoi1 = vnd / 23000;
        System.out.println("USD: " + quidoi1);
    }
}
