package ss17_io_binary_file_serialization.bai_tap.product_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    private static final String DATA_PATH = "src/ss17_io_binary_file_serialization/bai_tap/product_management/data.dat";

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("enter name: ");
        String name = scanner.nextLine();
        System.out.print("enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("enter description: ");
        String description = scanner.nextLine();
        Product newProduct = new Product(id, name, brand, price, description);

        List<Product> list = readDataFromFile(DATA_PATH);
        list.add(newProduct);
        writeFile(DATA_PATH, list);
    }

    public void display() {
        List<Product> list = readDataFromFile(DATA_PATH);
        for (Product product : list
        ) {
            System.out.println(product);
        }

    }

    public void edit() {
        List<Product> list = readDataFromFile(DATA_PATH);
        for (Product product : list
        ) {
            System.out.println(product);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id you want to edit: ");
        int idNeedEdit=Integer.parseInt(scanner.nextLine());
        System.out.println("enter new name: ");
        String name = scanner.nextLine();
        System.out.println("enter new brand: ");
        String brand= scanner.nextLine();
        System.out.println("enter new price: ");
        double price= Double.parseDouble(scanner.nextLine());
        System.out.println("enter new description: ");
        String description= scanner.nextLine();
        for (Product product:list){
            if (idNeedEdit==product.getId()){
                product.setName(name);
                product.setBrand(brand);
                product.setPrice(price);
                product.setDescription(description);
            }
        }
        writeFile(DATA_PATH,list);
    }

    public void search() {
        List<Product> list = readDataFromFile(DATA_PATH);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name of product: ");
        String nameNeedSearch = scanner.nextLine();
        for (Product product : list
        ) {
            if (product.getName().contains(nameNeedSearch)) {//contains ghi 1 trong nhung ki tu trung
                //equal thi phai trung het thi no moi in
                System.out.println(product);
            }
        }
    }

    public void delete() {
        List<Product> list = readDataFromFile(DATA_PATH);
        for (Product product : list
        ) {
            System.out.println(product);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id you want to delete: ");
        int idNeedDelete = Integer.parseInt(scanner.nextLine());

        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (idNeedDelete == list.get(i).getId()) {
                check = true;
                list.remove(i);
                System.out.println("deleted");
            }
        }
        if (!check) {
            System.out.println("no found");
        }

        writeFile(DATA_PATH, list);//phai ghi lai file
    }

    public static void writeFile(String pathLine, List<Product> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathLine);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String pathLine) {
        List<Product> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathLine);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
