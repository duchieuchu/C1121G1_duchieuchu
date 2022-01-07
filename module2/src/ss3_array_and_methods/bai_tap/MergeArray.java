package ss3_array_and_methods.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr1;
        int arr2;
        System.out.println("enter length of the array 1");
        arr1 = scanner.nextInt();
        System.out.println("enter length of the array 2");
        arr2 = scanner.nextInt();
        int array1[] = new int[arr1];
        int array2[] = new int[arr2];

        for (int i = 0; i < array1.length; i++) {
            System.out.print("Enter number of array1 at position " + (i + 1) + " is ");
            array1[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(array1));
        for (int j = 0; j < array2.length; j++) {
            System.out.println("Enter number of array2 at position " + j + 1);
            array2[j] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(array2));
        int array[] = new int[arr1 + arr2];
        for (int i = 0; i < array.length; i++) {
            if (i<array1.length){
                array[i] = array1[i];//lay pt arr1 bo vao arr
            }else {
                array[i] = array2[i-array1.length];//lay pt arr2 bo vao arr
            }
            System.out.println(Arrays.toString(array));
        }

    }

}
