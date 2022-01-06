package ss5_acess_modifier_static_method_and_property.thuc_hanh;

public class Student {
    private int rollNumber;
    private String name;
    private static String college = "kk";

    //ham khoi tao bien
    Student(int r, String n) {
        this.rollNumber = r;
        this.name = n;
    }

    //phuong thuc static dung de thay doi gia tri cua bien static
    static void change() {
        college = "CODEGYM";
    }

    void display() {
        System.out.println(rollNumber + " " + name + " " + college);
    }


}
