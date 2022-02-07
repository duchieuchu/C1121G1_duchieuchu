package FuramaResort.utils;

import FuramaResort.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFileAndReadFile {
    public static void writeFile(String pathFile,Employee employee) {
       try{
          FileWriter fileWriter = new FileWriter(pathFile,true);
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write(employee.writeToSCVFile());
           bufferedWriter.newLine();
           bufferedWriter.close();
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    public static List<String> readFile(String pathline) {
        List<String> listLine = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        try {
            fileReader = new FileReader(pathline);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
