package ss3_array_and_methods.thuc_hanh;

import java.util.Scanner;

public interface FindMaxElementInArray {
    public static void main(String[] args) {
        int size;//so lan nhap
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter size");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("size can not exceed 20");
            }
        } while (size > 20);
        array = new int[size];//Nhập giá trị cho các phần tử của mảng
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element" + (i+1) + ":");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("property list");// In ra danh sách tài sản đã nhập
        for (int j = 0;j< array.length;j++){
            System.out.print(array[j]+"\t");
        }
        int max = array[0];// Duyệt các phần tử trong mảng để tìm GTLN và vị trí
        int index = 1;
        for (int j = 0;j<array.length;j++){
                if (array[j]>max){
                    max = array[j];
                    index=j+1;
                }
        }
       System.out.println("The largest property value in the list is "+max+", at position: "+index);
    }
}
