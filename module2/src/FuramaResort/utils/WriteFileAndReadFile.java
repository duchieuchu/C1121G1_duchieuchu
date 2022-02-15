package FuramaResort.utils;

import FuramaResort.models.booking.Booking;
import FuramaResort.models.facility.Facility;
import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;
import FuramaResort.models.person.Customer;
import FuramaResort.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteFileAndReadFile {
    public static void writeEmployeeCSVFile(String pathFile,Employee employee) {//dung de add employee
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
    public static void writeCustomerSCVFile(String pathFile, Customer customer) {//dung de add customer
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
    public static void writeHouseSCVFile(String pathFile,String pathLineFacility, House house) {//dung de add customer
        try{
            FileWriter fileWriter = new FileWriter(pathFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(house.writeToCSVFile());
            bufferedWriter.newLine();
            bufferedWriter.close();

            FileWriter fileWriter1 = new FileWriter(pathLineFacility,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            bufferedWriter1.write(house.writeToCSVFile());
            bufferedWriter1.newLine();
            bufferedWriter1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void writeRoomCSVFile(String pathLine,String pathLineFacility, Room room){//dung de add room
        try{
            FileWriter fileWriter =new FileWriter(pathLine,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(room.writeCSVFile());
            bufferedWriter.newLine();
            bufferedWriter.close();

            FileWriter fileWriter1 =new FileWriter(pathLineFacility,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            bufferedWriter1.write(room.writeCSVFile());
            bufferedWriter1.newLine();
            bufferedWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeVillaCSVFile(String pathLine,String pathLineFacility, Villa villa){//dung de add villa
        try{
            FileWriter fileWriter =new FileWriter(pathLine,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(villa.writeCSVFile());
            bufferedWriter.newLine();
            bufferedWriter.close();

            FileWriter fileWriter1 =new FileWriter(pathLineFacility,true);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            bufferedWriter1.write(villa.writeCSVFile());
            bufferedWriter1.newLine();
            bufferedWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeBookingCSVFile(String pathLine, Booking booking){//dung de add villa
        try{
            FileWriter fileWriter =new FileWriter(pathLine,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(booking.writeCSVFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFileListEmployee(String pathFile,List<Employee> employeeList) {//dung edit
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
    public static void writeFileListCustomer(String pathFile,List<Customer> customerList) {//dung de edit
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
