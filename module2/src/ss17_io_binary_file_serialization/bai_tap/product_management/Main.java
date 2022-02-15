package ss17_io_binary_file_serialization.bai_tap.product_management;

import java.util.Scanner;

public class Main {
    //thêm, hiển thị, tìm kiếm thông tin sản phẩm vào file.
    public static void main(String[] args) {
        Management management = new Management();
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        while (check) {
            System.out.println("List of choice: ");
            System.out.println("1. Add product\n" +
                    "2. Display product\n" +
                    "3. Edit product\n" +
                    "4. Search product\n" +
                    "5. Delete product\n" +
                    "6. Exit");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    management.add();
                    break;
                case 2:
                    management.display();
                    break;
                case 3:
                    management.edit();
                    break;
                case 4:
                    management.search();
                    break;
                case 5:
                    management.delete();
                    break;
                case 6:
                    check = false;
                    break;
            }
        }
    }
}
