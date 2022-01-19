package ss13_seacrhing_algorithms.thuc_hanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baitap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int product= scanner.nextInt();


        for (int i = 1;i<=product;i++){
            if (product%i==0){
                System.out.println(i);
            }
            List<Integer> uocCuaProduct= new ArrayList<Integer>();
            uocCuaProduct.add(i);
        }
        int low = 0;
        int hight = product;
        System.out.println(product);
    }

}
