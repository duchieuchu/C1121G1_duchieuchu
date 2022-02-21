package ManagementProduct.utils;

import ManagementProduct.models.ExportProduct;
import ManagementProduct.models.ImportProduct;
import ManagementProduct.models.Product;

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

    public static List<Product> convertStringListToProductList(List<String> stringList) {
        List<Product> sanPhamList = new ArrayList<>();
        String[] stringSplitArray;
        Product.setNumber(1);
        for (String string : stringList) {
            stringSplitArray = string.split(",");
            if (stringSplitArray.length == 9) {
                ImportProduct importProduct = new ImportProduct(stringSplitArray[1], stringSplitArray[2],
                        Double.parseDouble(stringSplitArray[3]), Integer.parseInt(stringSplitArray[4]), stringSplitArray[5],
                        Double.parseDouble(stringSplitArray[6]), stringSplitArray[7], Double.parseDouble(stringSplitArray[8]));
                importProduct.setId(Integer.parseInt(stringSplitArray[0]));
                sanPhamList.add(importProduct);
            } else {
                ExportProduct exportProduct = new ExportProduct(stringSplitArray[1], stringSplitArray[2],
                        Double.parseDouble(stringSplitArray[3]), Integer.parseInt(stringSplitArray[4]), stringSplitArray[5],
                        Double.parseDouble(stringSplitArray[6]), stringSplitArray[7]);
                exportProduct.setId(Integer.parseInt(stringSplitArray[0]));
                sanPhamList.add(exportProduct);
            }
        }
        return sanPhamList;
    }

    public static List<String> convertProductListToStringList(List<Product> productList) {
        List<String> stringList = new ArrayList<>();
        for (Product product : productList) {
            stringList.add(product.toStringToFileCSV());
        }
        return stringList;
    }

}
