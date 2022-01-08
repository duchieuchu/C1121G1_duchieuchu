package ss2_loop.bai_tap;

import java.util.Scanner;

public class PrimesLessThan100 {
    public static void main(String[] args) {
        System.out.println("prime <100 is:");
        int count = 0;
        int i = 2;
        while (count < 25) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }
    public static boolean isPrime(int number) {
        int i = 2;
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
