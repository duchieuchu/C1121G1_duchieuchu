package ss1_instruction.thuc_hanh;
import java.util.Scanner;
public class UseTheOperator {
    public static void main(String[] args){
        float width;
        float height;

        Scanner scanner= new Scanner(System.in); //khai bao doi tuong Scanner

        System.out.println("Enter width: ");
        width=scanner.nextFloat();//nhap chieu rong

        System.out.println("Enter height: ");
        height=scanner.nextFloat();//nhap chieu dai
        float area=width*height;
        System.out.println("Area is: "+area);
    }
}
