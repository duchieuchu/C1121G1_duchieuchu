package bai_tap_lam_them.student.services;

import bai_tap_lam_them.student.models.Student;
import bai_tap_lam_them.student.utils.WriteAndReadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private static final String STUDENT_PATH = "src/bai_tap_lam_them/student/data/student.csv";
    List<Student> studentList;

    public void add() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter name: ");
        String name = scanner.nextLine();
        System.out.print("enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("enter dayOfBirth: ");
        String dayOfBirth = scanner.nextLine();
        System.out.print("enter numberPhone: ");
        String numberPhone = scanner.nextLine();
        System.out.print("enter address: ");
        String address = scanner.nextLine();
        Student newStudent = new Student(name, gender, dayOfBirth, numberPhone, address);
        WriteAndReadFile.writeStudentCSVFile(STUDENT_PATH, newStudent);

    }

    public void display() {
        studentList = readStudentCSVFileToStudentList(STUDENT_PATH);
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }

    public static List<Student> readStudentCSVFileToStudentList(String pathLine) {
        List<Student> studentListFromReadSCVFile = new ArrayList<>();
        List<String> lineList = WriteAndReadFile.readFile(STUDENT_PATH);
        String[] lineSplitList;

        for (String line : lineList) {
            lineSplitList = line.split(",");
            studentListFromReadSCVFile.add(new Student(lineSplitList[0],
                    lineSplitList[1],
                    lineSplitList[2],
                    lineSplitList[3],
                    lineSplitList[4]));

        }
        return studentListFromReadSCVFile;
    }
}
