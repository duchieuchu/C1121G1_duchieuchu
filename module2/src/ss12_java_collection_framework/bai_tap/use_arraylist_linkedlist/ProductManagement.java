package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagement {

    private static ArrayList<Product> productArrayList = new ArrayList<Product>();

    static {
        Product products1 = new Product(1001, "IPhone11", 15000000, "64GB");
        Product products2 = new Product(1002, "Iphone12ProMax", 32000000, "128GB");
        Product products3 = new Product(1003, "Iphone12Pro", 27000000, "128GB");
        productArrayList.add(products1);
        productArrayList.add(products2);
        productArrayList.add(products3);
    }

    //them sp
    public static void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        System.out.print("Enter information: ");
        String information = scanner.nextLine();
        Product product = new Product(id, name, price, information);
        productArrayList.add(product);
    }

    //hien thi ds san pham
    public static void showList() {
        for (Product list : productArrayList
        ) {
            System.out.println(list);
        }
    }

    //xoa
    public static void delete() {
        showList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of product you want to delete");
        int id = scanner.nextInt();
        for (Product product : productArrayList
        ) {
            if (product.getId() == id) {
                productArrayList.remove(product);
            }
        }
    }
    //sua
    public static void edit(){
        
    }
}
