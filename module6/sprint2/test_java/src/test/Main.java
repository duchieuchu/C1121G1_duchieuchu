package test;

public class Main {
    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("111");

        StringBuffer str2 = str1;
        str1.append("222");
        System.out.println("str1: "+str1);
        System.out.println("str2: "+str2);


//        String str1 = new String("111");
//        String str2 = str1;
//
//        str1 = str1.concat("222");
//        System.out.println("str1: "+str1);
//        System.out.println("str2: "+str2);
    }
}


//    Short s1 = 200;
//    Integer s2 = 400;
//    Long s3 = (long) s1 + s2;
//
////        String s4 = (String) s3 * s2;
////        String s4 = String.valueOf(s3*s2);
////        System.out.println(s4);
////        Long s5 = Long.valueOf(s4);
////        System.out.println(s5);
