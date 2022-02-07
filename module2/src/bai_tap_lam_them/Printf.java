package bai_tap_lam_them;

import java.util.Date;
import java.util.Locale;

public class Printf {
    public static void main(String[] args) {
//        System.out.print("hello");
//        System.out.print("1");
//
//        System.out.println("hello");
//        System.out.println("1");
//
        //%c: Ký tự
        //%d: Số thập phân (số nguyên) (cơ số 10)
        //%e: Dấu phẩy động theo cấp số nhân
        //%f: Dấu phẩy động
        //%i: Số nguyên (cơ sở 10)
        //%o: Số bát phân (cơ sở 8)
        //%s: Chuỗi
        //%u: Số thập phân (số nguyên) không dấu
        //%x: Số trong hệ thập lục phân (cơ sở 16)
        //%t: Định dạng ngày / giờ
        //%%: Dấu phần trăm
        //\%: Dấu phần trăm
       // System.out.printf("%s\n%s","hello","1");

//        Date data =new Date(0);
//        System.out.printf(Locale.GERMANY,"ngay gio hien tai: %tc",data);

//in hoa
//        String string = "the end";
//        System.out.printf("%S\n",string);
//        System.out.printf("%S\n","hello");

        //in so nguyen , so thuc
//        int x=666;
//        double y=33.99;
//        System.out.printf("%d\n%.2f",x,y);

        //in dang boolean
//        System.out.printf("%b%n",false);
//        System.out.printf("%b%n",1);
//        System.out.printf("%b%n","false");

        //in ngay thang gio hien tai
        Date date=new Date();
        System.out.printf("%tT%n",date);
        System.out.printf("H : %tH, M: %tM, S: %tS%n",date,date,date);
        System.out.printf("Ngay/thang/nam: %1$td.%1$tm,%1$ty %n",date);
        System.out.printf("%s %tb %<te, %<ty","ngay hien tai: ",date);
    }
}
