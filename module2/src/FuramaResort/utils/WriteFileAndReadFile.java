package FuramaResort.utils;

import FuramaResort.models.person.Customer;
import FuramaResort.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFileAndReadFile {
    public static void writeEmployeeCSVFile(String pathFile,Employee employee) {
       try{
          FileWriter fileWriter = new FileWriter(pathFile,true);
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write(employee.writeToCSVFile());
           bufferedWriter.newLine();
           bufferedWriter.close();
       }catch (IOException e){
           e.printStackTrace();
       }
    }
    public static void writeCustomerSCVFile(String pathFile, Customer customer) {
        try{
            FileWriter fileWriter = new FileWriter(pathFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(customer.writeToCSVFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void writeFileListEmployee(String pathFile,List<Employee> employeeList) {
        try{
            FileWriter fileWriter = new FileWriter(pathFile,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee:employeeList
                 ) {
                bufferedWriter.write(employee.writeToCSVFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void writeFileListCustomer(String pathFile,List<Customer> customerList) {
        try{
            FileWriter fileWriter = new FileWriter(pathFile,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer:customerList
            ) {
                bufferedWriter.write(customer.writeToCSVFile());
                bufferedWriter.newLine();
            }
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
