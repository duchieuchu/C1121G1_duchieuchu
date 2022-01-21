package bai_tap_lam_them.WriteAndReadFile;

import bai_tap_lam_them.WriteAndReadFile.common.File;
import bai_tap_lam_them.WriteAndReadFile.model.Student;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static final String FILE_NAME = "src/bai_tap_lam_them/WriteAndReadFile/data/student.csv";
    public static final String COMMA = ",";

    public static void main(String[] args) {
//        //out file
//        Student student1 = new Student(2, "hieu1", "00/00/2122");
//        Student student2 = new Student(3, "lan", "00/00/2021");
//        Student student3 = new Student(4, "hao", "00/00/2023");
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(student1);
//        studentList.add(student2);
//        studentList.add(student3);
////ghi file
//        String line = null;
//        for (Student student : studentList
//        ) {
//            line = student.getId() + COMMA + student.getName() + COMMA + student.getDateOfBirth();
//            File.writeFile(FILE_NAME, line);
//
//        }
////doc file
        List<String> listLine = File.readFile(FILE_NAME);
        System.out.println(listLine);

        String[] lineSplit = listLine.get(0).split(COMMA);
        Student student = new Student(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2]);
        System.out.println(student.getId() + " " + student.getName() + " " + student.getDateOfBirth());
    }

}
