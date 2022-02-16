package ss19_string_regex.bai_tap.validate_name_class;

import java.util.Scanner;

public class ClassNameTest {
    private static ClassName className;
    public static void main(String[] args) {
        className= new ClassName();
        Scanner scanner= new Scanner(System.in);
        System.out.print("enter className: ");
        String className1= scanner.nextLine();

        boolean check = className.validate(className1);
        System.out.println("className: "+className1+" is "+check);


    }
}
