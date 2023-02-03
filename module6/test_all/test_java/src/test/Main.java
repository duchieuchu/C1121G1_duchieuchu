package test;

public class Main {
   public static void main(String[] args) {
    int sum = 0;
        for (int i = 0; i < 20; i++) {
        if (isPrime(i)) {
            System.out.println(i);
            sum += i;
        }
    }
        System.out.println("tong so la "+sum);
}

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
