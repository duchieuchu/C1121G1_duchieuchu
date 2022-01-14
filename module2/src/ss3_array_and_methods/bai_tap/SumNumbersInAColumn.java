package ss3_array_and_methods.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumNumbersInAColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rows of array: ");
        int rows= scanner.nextInt();
        System.out.print("Enter columns of array: ");
        int col=scanner.nextInt();
        int number [][]=new int[rows][col];
        for (int i =0;i<number.length;i++){
            for (int j = 0;j< col;j++){
                System.out.println("enter number at position: "+i+j+",");
                number[i][j]= scanner.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(number));
        int column;
        do {
            System.out.println("Enter column to calculate");
            column= scanner.nextInt();
            if (column>col-1||column<0){
                System.out.println("Enter again");
            }
        }while (column>col-1||column<0);
        int sum = 0;
        for (int i= 0;i<number.length;i++){
            sum = sum+number[i][column];
        }
        System.out.println("sum of number at column "+column+" is "+sum);
    }
}
