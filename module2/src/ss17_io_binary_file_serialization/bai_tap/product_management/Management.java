package ss17_io_binary_file_serialization.bai_tap.product_management;

import java.io.*;

import java.util.List;

public class Management {
    public static void writeToFile(String pathLine, List<Product> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathLine);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
