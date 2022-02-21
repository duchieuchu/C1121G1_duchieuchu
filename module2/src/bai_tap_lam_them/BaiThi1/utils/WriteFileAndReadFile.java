package bai_tap_lam_them.BaiThi1.utils;

import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhNhan;
import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhNhanVip;
import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhThuong;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WriteFileAndReadFile {
    public static <E> void writeListToCSVFile(List<E> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E element : list) {
                if (element instanceof BenhAnCuaBenhThuong) {
                    bufferedWriter.write(((BenhAnCuaBenhThuong) element).getInfoToWriteFileCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof BenhAnCuaBenhNhanVip) {
                    bufferedWriter.write(((BenhAnCuaBenhNhanVip) element).getInfoToWriteFileCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BenhAnCuaBenhNhan> readBenhAnFromCSVFile(String filePath) {
        List<BenhAnCuaBenhNhan> productList = new LinkedList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 8) {
                    BenhAnCuaBenhThuong benhAnCuaBenhThuong =new BenhAnCuaBenhThuong(
                            Integer.parseInt(array[0]),array[1],array[2],array[3],array[4],array[5],
                            array[6],Double.parseDouble(array[7])
                    );
                    productList.add(benhAnCuaBenhThuong);
                } else {
                    BenhAnCuaBenhNhanVip benhAnCuaBenhNhanVip = new BenhAnCuaBenhNhanVip(
                            Integer.parseInt(array[0]),array[1],array[2],array[3],array[4],array[5],
                            array[6],array[7],array[8]
                            );
                    productList.add(benhAnCuaBenhNhanVip);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
