package bai_tap_lam_them.student.utils;

import bai_tap_lam_them.student.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {
    public static void writeStudentCSVFile(String pathLine, Student student) throws IOException {
        FileWriter fileWriter = new FileWriter(pathLine, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(student.writeToSCVFile());
        bufferedWriter.newLine();
        bufferedWriter.close();


    }

    public static List<String> readFile(String pathLine) {
        List<String> listLine = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        try {
            fileReader = new FileReader(pathLine);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listLine;
    }
}
