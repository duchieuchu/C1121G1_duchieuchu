package ss16_io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        copyText("src/ss16_io_text_file/bai_tap/copy_file_text/OriginalFile.txt",
                "src/ss16_io_text_file/bai_tap/copy_file_text/CloneFile.txt");
    }
    public static void copyText(String pathOriginalFile, String pathCloneFile) {
        FileReader fileReader;
        FileWriter fileWriter;
        String line;
        try {
            fileReader = new FileReader(pathOriginalFile);
            fileWriter = new FileWriter(pathCloneFile);
            BufferedReader bufferedReader= new BufferedReader(fileReader);//bo nho tam
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while ((line = bufferedReader.readLine())!= null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
