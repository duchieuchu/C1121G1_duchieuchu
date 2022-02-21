package ManagementProduct.controllers;

import ManagementProduct.services.ManagementProductImpl;
import ManagementProduct.utils.NotFoundProductException;

import java.util.Scanner;

public class ManagementProductController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        ManagementProductImpl managementProduct = new ManagementProductImpl();
        boolean check = true;
        while (check) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM –\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các sản phẩm\n" +
                    "4. Tìm kiếm\n" +
                    "5. Thoát\n" +
                    "Chọn chức năng:\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    chooseProductToAdd();
                    break;
                case 2:
                    try {
                        managementProduct.delete();
                    } catch (NotFoundProductException e) {
                        System.out.println("no found product you need delete!!!");
                    }
                    break;
                case 3:
                    managementProduct.display();
                    break;
                case 4:
                    managementProduct.search();
                    break;
                case 5:
                    check = false;
                    break;
                default:
                    System.out.println("enter again!!!");
                    displayMainMenu();
            }
        }
    }

    public static void chooseProductToAdd() {
        ManagementProductImpl managementProduct = new ManagementProductImpl();

        System.out.println("1.Add exportProduct\n" +
                "2.Add importedProduct");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                managementProduct.addExportProduct();
                break;
            case 2:
                managementProduct.addImportProduct();
                break;
            default:
                System.out.println("enter again!!!");
                chooseProductToAdd();
        }
    }
}
