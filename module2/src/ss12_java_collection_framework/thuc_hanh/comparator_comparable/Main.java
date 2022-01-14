package ss12_java_collection_framework.thuc_hanh.comparator_comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student=new Student("lan",18,"dn");
        Student student1=new Student("linh",19,"dn");
        Student student2=new Student("hoa",21,"dn");
        Student student3=new Student("dung",20,"dn");

        List<Student> lists= new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);//sx theo abcd
        for (Student students:lists
             ) {
            System.out.println(students.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println("sap xep theo tuoi");
        for (Student students:lists
             ) {
            System.out.println(students.toString());
            
        }


    }
}
