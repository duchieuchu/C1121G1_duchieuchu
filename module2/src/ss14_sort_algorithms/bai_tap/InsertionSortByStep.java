package ss14_sort_algorithms.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter size: ");
        int size = scanner.nextInt();
        int numberArray[] = new int[size];
        System.out.println("enter " + size + " value :");
        //bo phan tu vao mang
        for (int j = 0; j < numberArray.length; j++) {
            numberArray[j] = scanner.nextInt();
        }
        System.out.println("array before sorting:  ");
        for (int j = 0; j < numberArray.length; j++) {
            System.out.println(numberArray[j]);
        }
        System.out.println("begin sort processing:  ");
        insertionSort(numberArray);
    }

    public static void insertionSort(int numberArray[]) {
        int x;
        int pos;
        for (int i = 1; i < numberArray.length; i++) {
            x = numberArray[i];
            pos = i;
            while (pos > 0 && x<numberArray[pos - 1]) {
                numberArray[pos] = numberArray[pos - 1];//swap pos va pos -1
                pos--;
//                System.out.println("vong lap while da chay");
            }
            numberArray[pos]=x;
            System.out.println("lan thu "+ i+": "+ Arrays.toString(numberArray));
        }
    }
}
