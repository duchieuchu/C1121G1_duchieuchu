package ss1_instruction.thuc_hanh;

import java.util.Scanner;

public class DaysInAMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month do you want to count  days in? ");
        int month = scanner.nextInt();
//        switch (month) {
//            case 2:
//                System.out.println("The month '2' has 28 or 29 days!");
//                break;
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                System.out.println("The month'" + month + "'has 31 days!");
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                System.out.println("The month'" + month + "'has 31 days");
//                break;
//            default:
//                System.out.println("Invalid input!");
//                break;
//
//        }
        String daysInAMonth;
        switch (month) {
            case 2:
                daysInAMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInAMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInAMonth = "30";
                break;
            default:
                daysInAMonth = "";
        }
        if (!daysInAMonth.equals("")) System.out.printf("The month'%d' has %s days!",month,daysInAMonth);
        else System.out.println("Invalid input!");
    }
}
