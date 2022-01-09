package ss3_array_and_methods.bai_tap;

import java.util.Scanner;

public class DeleteElementOfArray {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("1,2,3,4,5,6,7,8,9");
        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.println("Enter element you want to delete: ");
        x = scanner.nextInt();
        int index = 0;
        boolean check = true;
        // tim x  trong mang
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                check = true;
                index = i;// vi tri phan tu neu co
                //Duyệt mảng từ vị trí cần xoá (index_del) đến cuối mảng (array.length-1)
                for (int j = i; j < array.length; j++) {
                    if (j < array.length - 1) {
                        array[j] = array[j + 1];//Gán phần tử ở vị trí index cho phần tử ở vị trí index + 1
                    } else {
                        array[j] = 0;
                    }
                }
                index = i;
                break;
            } else {
                check = false;
            }
        }
        if (check) {
            for (int number : array) {
                System.out.print(number + ",");
            }
        } else {
            System.out.println("The number you entered is not in the array");
        }
    }
}
