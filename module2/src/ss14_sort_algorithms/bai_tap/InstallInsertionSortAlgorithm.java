package ss14_sort_algorithms.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class InstallInsertionSortAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter size");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("enter " + size + " value:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }

        System.out.println("list before sorting: ");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + "\t");
        }

        System.out.println("Begin sort processing...");
        insertSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void insertSort(int[] list) {
        int pos, x;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            System.out.println(x);
            pos = i;
            System.out.println(x);
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
                list[pos] = x;
            }
        }
    }
}
