package FuramaResort.utils;

import FuramaResort.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFileAndReadFile {
    public static void writeListStringIntoCSVFile(String pathFile, List<String> stringList, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
       try{
           fileWriter = new FileWriter(pathFile,append);
           for (String string :stringList
                ) {bufferedWriter.write(string);
               bufferedWriter.newLine();//de xuong hang
           }
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           if (bufferedWriter != null){
               try{
                   bufferedWriter.close();
               }catch (IOException e){
                   e.printStackTrace();
               }
           }
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
