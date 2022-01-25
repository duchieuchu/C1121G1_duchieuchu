package bai_tap_lam_them;

public class Demo {
    public static void main(String[] args) {
        String n1="abc";//tao"abc"' luu vung nho  string Pool(trong heap)
        String n2="abc";
        n1="abce";
        String n3=n1;
        String n4=new String("abc");
        String n5=new String("abc");
        n5+="sda";//cong don

        System.out.println(n5);
        System.out.println(n1==n2);
        System.out.println(n3==n2);
        System.out.println(n4==n1);
        System.out.println(n4.equals(n5));//equal so sanh gia tri
        StringBuffer stringBuffer= new StringBuffer("abc");//co dong bo,an toan hon
        stringBuffer.append("efg");
        StringBuilder stringBuilder = new StringBuilder("sds");//khong dong bo,xu li nhanh hon
        stringBuilder.append("âssa");
        System.out.println(stringBuffer);
        System.out.println(stringBuilder);
    }
}
