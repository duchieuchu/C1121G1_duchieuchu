package ss3_array_and_methods.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfNumbersOnDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System .in);
        int row;
        System.out.println("Enter row number:");
        row= Integer.parseInt(scanner.nextLine());
        int number[][]=new int[row][row];
      for (int i = 0;i<row;i++){
          for (int j = 0; j<row;j++){
              System.out.println("enter element: "+i+" "+j);
              number[i][j]=Integer.parseInt(scanner.nextLine());
          }
      }
        System.out.println("display number array");
        System.out.println(Arrays.deepToString(number));
        int sum = 0;
        for (int i = 0 ;i< number.length;i++){
            sum= sum+number[i][i]+number[i][number.length-1-i];
        }
        System.out.println("sum is "+sum);
    }
}
