package ss5_acess_modifier_static_method_and_property.bai_tap;

public class Student {
    private String name= "John";
    private String classes="C1121G1";
    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
