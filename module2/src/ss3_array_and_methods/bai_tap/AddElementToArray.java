package ss3_array_and_methods.bai_tap;

import java.util.Scanner;
import java.util.Arrays;

public class AddElementToArray {
    public static void main(String[] args) {
        System.out.println("18,19,20,21");
        int array[] = {18, 19, 20, 21, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        int x;// X là số cần chèn
        int index;// vị trí index cần chèn X vào trong mảng
        System.out.println("Enter X element: ");
        x = scanner.nextInt();
        System.out.println("Enter element's position: ");
        index = scanner.nextInt();

//        if (index < 0 && index > array.length) {
//            System.out.println("can not add element");
//        }
            for (int i = array.length - 1; i >= index; i--) {
                if (i != index) {
                    array[i] = array[i - 1];
                } else {
                    array[i] = x;
                }
            }
            System.out.println(Arrays.toString(array));
    }
}
