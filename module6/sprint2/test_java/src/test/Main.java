package test;

public class Main {
    public static void main(String[] args) {
        Short s1 = 200;
        Integer s2 = 400;
        Long s3 = (long) s1 + s2;
        String s4 = String.valueOf(s3*s2);
        System.out.println(s4);
        Long s5 = Long.valueOf(s4);
        System.out.println(s5);
//        String s4 = (String) s3 * s2;
    }
}
