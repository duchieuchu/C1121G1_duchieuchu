package ss5_acess_modifier_static_method_and_property.thuc_hanh;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();//goi phuong thuc thay doi
        //tao doi tuong
        Student s1 = new Student(11, "lan");
        Student s2 = new Student(22, "linh");
        Student s3 = new Student(33, "dao");
//goi phuong thuc hien thi
    s1.display();
    s2.display();
    s3.display();
    }
}
