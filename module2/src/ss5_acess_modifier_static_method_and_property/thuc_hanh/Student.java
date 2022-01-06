package ss5_acess_modifier_static_method_and_property.thuc_hanh;

public class Student {
    private int rollno;
    private String name;
    private static String college = "kk";

    //ham khoi tao bien
    Student(int r, String n) {
        this.rollno = r;
        this.name = n;
    }

    //phuong thuc static dung de thay doi gia tri cua bien static
    static void change() {
        college = "CODEGYM";
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }


}
