package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist;

import java.util.Scanner;

public class MainProduct {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ProductManagement management= new ProductManagement();
        boolean check = true;
        while (check) {
            System.out.println("List of choices:");
            System.out.println("1.Add \n"+"2.Edit\n"+"3.Delete\n"
                    +"4.Show products\n"+"5.Search products\n" +
                    "6.Sort up\n"+"7 Sort down\n"+"8.Exit");
            System.out.println("Enter your choice");
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    management.add();
                    break;
                case 2:
                    management.edit();
                    break;
                case 3:
                    management.delete();
                    break;
                case 4:
                    break;
                case 5:

                case 6:

                case 7:

                case 8:

            }
        }
    }
}
