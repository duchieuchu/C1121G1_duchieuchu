package ss5_acess_modifier_static_method_and_property.bai_tap;

public class TestStudent {
    public static void main(String[] args) {
        Student student=new Student();
        System.out.println(student.toString());
        //sau khi set
        student.setName("han");
        student.setClasses("c1");
        System.out.println(student.toString());
    }

}
