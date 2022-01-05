package ss2_loop.bai_tap;

public class Fisrt20Prime {
    public static void main(String[] args) {
        byte count= 1;
        int n = 2;
        System.out.println("First 20 Primes: ");
        while (count < 20) {
            boolean check = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(n);
                count++;
            }n++;
        }
    }
}
