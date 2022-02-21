package BaiThi.utils;

import BaiThi.models.BenhNhanVip;
import BaiThi.models.BenhNhan;
import BaiThi.models.BenhNhanThuong;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFileAndReadFile {
    public static List<String> readFileCSVToStringList(String pathFile) {
        List<String> stringList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        try {
            fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
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
        return stringList;
    }

    public static void writeStringListIntoCSVFile(String pathFile, List<String> stringList, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<BenhNhan> convertStringListToBenhAnList(List<String> stringList) {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        String[] stringSplitArray;
        BenhNhan.setNumber(1);
        for (String string : stringList) {
            stringSplitArray = string.split(",");
            if (stringSplitArray.length == 7) {
                BenhNhanThuong benhNhanThuong = new BenhNhanThuong(stringSplitArray[0],
                        stringSplitArray[1],
                        stringSplitArray[2],
                        stringSplitArray[3],
                        stringSplitArray[4],
                        stringSplitArray[5],
                        Double.parseDouble(stringSplitArray[6]));
                benhNhanList.add(benhNhanThuong);
            } else {
                BenhNhanVip benhNhanVip= new BenhNhanVip(stringSplitArray[0],
                        stringSplitArray[1],
                        stringSplitArray[2],
                        stringSplitArray[3],
                        stringSplitArray[4],
                        stringSplitArray[5],
                        stringSplitArray[6],
                        stringSplitArray[7]);
                benhNhanList.add(benhNhanVip);
            }
        }
        return benhNhanList;
    }

    public static List<String> convertBenhAnListToStringList(List<BenhNhan> benhNhanList) {
        List<String> stringList = new ArrayList<>();
        for (BenhNhan benhNhan : benhNhanList) {
            stringList.add(benhNhan.toStringToFileCSV());
        }
        return stringList;
    }
}
