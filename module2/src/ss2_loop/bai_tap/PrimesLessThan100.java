package ss2_loop.bai_tap;

public class PrimesLessThan100  {
    public static void main(String[] args){
        int n=3;
        System.out.println("Primes less than 100: ");
        while (n<100){
            boolean check = true;
            for(int i = 2;i<n;i++){
                if(n%i==0){
                    check= false;
                    break;
                }
            }if (check){
                System.out.println(n);
            }n++;
        }
    }
}
