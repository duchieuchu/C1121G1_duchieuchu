package ss19_string_regex.bai_tap.validate_number_phone;

import java.util.Scanner;

public class NumberPhoneExampleTest {
   private static NumberPhoneExample numberPhoneExample;

    public static void main(String[] args) {
        numberPhoneExample=new NumberPhoneExample();
        Scanner scanner=new Scanner(System.in);
        System.out.print("enter number phone: ");
        String numberPhone= scanner.nextLine();

        boolean check= numberPhoneExample.validate(numberPhone);
        System.out.println("numberPhone: "+numberPhone+" is"+check);
    }
}
