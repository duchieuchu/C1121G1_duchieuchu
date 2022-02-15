package bai_tap_lam_them.student.controllers;

import bai_tap_lam_them.student.services.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) throws IOException {
        StudentService studentService = new StudentService();
        System.out.println("1.add student");
        System.out.println("2.display student");
        System.out.print("Enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                studentService.add();
                break;
            case 2:
                studentService.display();
                break;
        }
    }
}
