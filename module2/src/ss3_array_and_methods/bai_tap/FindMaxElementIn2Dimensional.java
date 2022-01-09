package ss3_array_and_methods.bai_tap;


import java.util.Scanner;

public class FindMaxElementIn2Dimensional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row;//hang
        int col;//cot
        System.out.println("Enter row number of array: ");
        row = scanner.nextInt();
        System.out.println("Enter col number of array: ");
        col = scanner.nextInt();

        int array[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter element at position: " + " row: " + i + " col: " + j + " ");
                array[i][j] = scanner.nextInt();
            }
        }
        int max = array[0][0];
        int indexRow = 0;
        int indexCol = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.println("Max: " + max + " at position row: " + indexRow + ", col:" + indexCol);
    }
}
