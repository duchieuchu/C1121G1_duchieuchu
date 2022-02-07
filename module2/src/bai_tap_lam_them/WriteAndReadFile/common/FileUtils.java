package bai_tap_lam_them.WriteAndReadFile.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void writeFile(String pathFile, String line) {//pathFile= duong dan file,
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);//true ghi du lieu cuoi file,
            // false de file bien mat thong tin file cu
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);//pt write ghi
            bufferedWriter.newLine();// tao dong moi

            bufferedWriter.close();//dong file,luu lai
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String pathLine) {
        List<String> listLine = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(pathLine);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }
}
