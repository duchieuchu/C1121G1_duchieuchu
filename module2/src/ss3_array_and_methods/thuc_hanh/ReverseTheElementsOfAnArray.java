package ss3_array_and_methods.thuc_hanh;

import java.util.Scanner;

public class ReverseTheElementsOfAnArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();//nhap size
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();//nhap pt
            i++;
        }
        System.out.println("Elements in array: ");//hien thi pt
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        //dao nguoc pt
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("Reverse array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
