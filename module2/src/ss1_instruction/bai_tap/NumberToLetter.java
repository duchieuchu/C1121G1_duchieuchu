package ss1_instruction.bai_tap;

import java.util.Scanner;

public class NumberToLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int number = scanner.nextInt();
        int tens;
        int ones;
        int hundreds;
        if (number < 10 && number >= 0) {
            switch (number) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (number < 20) {
            switch (number) {
                case 10:
                    System.out.println("ten");
                    break;
                case 11:
                    System.out.println("eleven");
                    break;
                case 12:
                    System.out.println("twelve");
                    break;
                case 13:
                    System.out.println("thirteen");
                    break;
                case 14:
                    System.out.println("fourteen");
                    break;
                case 15:
                    System.out.println("fifteen");
                    break;
                case 16:
                    System.out.println("sixteen");
                    break;
                case 17:
                    System.out.println("seventeen");
                    break;
                case 18:
                    System.out.println("eighteen");
                    break;
                case 19:
                    System.out.println("nineteen");
                    break;
            }
        } else if (number < 100) {
            tens = (int) number / 10;
            ones = (int) number - (tens * 10);
            switch (tens) {
                case 2:
                    System.out.print("twenty ");
                    break;
                case 3:
                    System.out.print("thirty ");
                    break;
                case 4:
                    System.out.print("forty ");
                    break;
                case 5:
                    System.out.print("fifty ");
                    break;
                case 6:
                    System.out.print("sixty ");
                    break;
                case 7:
                    System.out.print("seventy ");
                    break;
                case 8:
                    System.out.print("eighty ");
                    break;
                case 9:
                    System.out.print("ninety ");
                    break;
                default:
            }
            switch (ones) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (number < 1000) {
            hundreds = (int) number / 100;
            tens = (int) (number % 100) / 10;
            ones = (int) number - (number / 10 * 10);
            if (number % 100 == 0) {
                switch (hundreds) {
                    case 1:
                        System.out.print("one hundred ");
                        break;
                    case 2:
                        System.out.println("two hundred ");
                        break;
                    case 3:
                        System.out.println("three hundred ");
                        break;
                    case 4:
                        System.out.println("four hundred ");
                        break;
                    case 5:
                        System.out.println("five hundred ");
                        break;
                    case 6:
                        System.out.println("six hundred ");
                        break;
                    case 7:
                        System.out.println("seven hundred ");
                        break;
                    case 8:
                        System.out.println("eight hundred ");
                        break;
                    case 9:
                        System.out.println("nine hundred ");
                        break;
                }
            } else {
                switch (hundreds) {
                    case 1:
                        System.out.print("one hundred and ");
                        break;
                    case 2:
                        System.out.print("two hundred and ");
                        break;
                    case 3:
                        System.out.print("three hundred and ");
                        break;
                    case 4:
                        System.out.print("four hundred and ");
                        break;
                    case 5:
                        System.out.print("five hundred and ");
                        break;
                    case 6:
                        System.out.print("six hundred and ");
                        break;
                    case 7:
                        System.out.print("seven hundred and ");
                        break;
                    case 8:
                        System.out.print("eight hundred and ");
                        break;
                    case 9:
                        System.out.print("nine hundred and ");
                        break;
                }
                switch (tens) {
                    case 2:
                        System.out.print("twenty ");
                        break;
                    case 3:
                        System.out.print("thirty ");
                        break;
                    case 4:
                        System.out.print("forty ");
                        break;
                    case 5:
                        System.out.print("fifty ");
                        break;
                    case 6:
                        System.out.print("sixty ");
                        break;
                    case 7:
                        System.out.print("seventy ");
                        break;
                    case 8:
                        System.out.print("eighty");
                        break;
                    case 9:
                        System.out.print("ninety ");
                        break;
                }
                switch (ones) {
                    case 1:
                        System.out.print("one");
                        break;
                    case 2:
                        System.out.println("two");
                        break;
                    case 3:
                        System.out.println("three");
                        break;
                    case 4:
                        System.out.println("four");
                        break;
                    case 5:
                        System.out.println("five");
                        break;
                    case 6:
                        System.out.println("six");
                        break;
                    case 7:
                        System.out.println("seven");
                        break;
                    case 8:
                        System.out.println("eight");
                        break;
                    case 9:
                        System.out.println("nine");
                        break;
                }
            }
        }
    }
}
