package ss1_instruction.thuc_hanh;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height, weight, bmi;
        System.out.println("Enter weight: ");
        weight = scanner.nextDouble();
        System.out.println("Enter height: ");
        height = scanner.nextDouble();
        bmi = weight/Math.pow(height,2);
        System.out.printf("%-20s%s", "bmi", "Interpretation");
        if (bmi < 18) {
            System.out.printf("%-20.2f%s", bmi, "UnderWeight");
            }
        else if (bmi < 25.0){
            System.out.printf("%-20.2f%s",bmi,"Normal");
        }
        else if(bmi <30.0){
            System.out.printf("%-20.2f%s",bmi,"OverWeight");
        }else {
            System.out.printf("%-20.2f%s",bmi,"Obese");
        }
    }
}
