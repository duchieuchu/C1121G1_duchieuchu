package ss3_array_and_methods.bai_tap;

import java.util.Scanner;

public class CountLetterInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "life";
        String enter;
        System.out.println("enter a letter: ");
        enter = scanner.nextLine();
        int count=0;
        for (int i = 0;i<string.length();i++){
            if (string.charAt(i)==enter.charAt(0));
            count++;
        }
        System.out.println(count);
    }
}
