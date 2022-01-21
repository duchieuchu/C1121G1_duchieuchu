package bai_tap_lam_them.WriteAndReadFile.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static void writeFile(String pathFile, String line) {//pathFile= duong dan file,line = dong muon ghi
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);//viet
            bufferedWriter.newLine();
            bufferedWriter.close();//dong file,luu lai
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String pathLine) {
        List<String> listLine = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(pathLine);
            String line = null;
            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
