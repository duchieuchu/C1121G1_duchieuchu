package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist.services;

import ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManagement implements IProductService {

    private static ArrayList<Product> productArrayList = new ArrayList<Product>();

    static {
        Product products1 = new Product(1001, "IPhone11", 15000, "64GB");
        Product products2 = new Product(1002, "Iphone12ProMax", 32000, "128GB");
        Product products3 = new Product(109, "Iphone12Pro", 27000, "128GB");
        Product products4 = new Product(99, "Iphone12Pro", 30000, "128GB");

        productArrayList.add(products1);
        productArrayList.add(products2);
        productArrayList.add(products3);
        productArrayList.add(products4);

    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter information: ");
        String information = scanner.nextLine();
        Product product = new Product(id, name, price, information);
        productArrayList.add(product);
    }

    public void showList() {

        for (Product list : productArrayList
        ) {
            System.out.println(list);
        }
    }

    public void delete() {
        showList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of product you want to delete");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : productArrayList) {
            if (product.getId() == id) {
                productArrayList.remove(product);
            }
        }
    }

    public void edit() {
        showList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of product you want to edit");
        int idEdit = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new information: ");
        String information = scanner.nextLine();
        for (Product product : productArrayList) {
            if (product.getId() == idEdit) {
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setInformation(information);
            }
        }
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name you want to search: ");
        String name = scanner.nextLine();
        for (Product product : productArrayList) {
            if (product.getName().contains(name)) {
                System.out.println(product);
            }
        }
    }

    public void sortUp() {
        Collections.sort(productArrayList, new SortAscending());
    }

    public void sortDown() {
        Collections.sort(productArrayList, new SortDescending());
    }

}
