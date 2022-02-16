package ss19_string_regex.thuc_hanh.validate_email;

import java.util.Scanner;

public class EmailExampleTest {
    private static EmailExample emailExample;

    //    public static final String[] validEmail= new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
//    public static final String[] invalidEmail=new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};
//
//    public static void main(String[] args) {
//        emailExample= new EmailExample();
//        for (String email: validEmail){
//            boolean isValid = emailExample.validate(email);
//            System.out.println("email: "+email+", isValid: "+isValid);
//        }
//        for (String email: invalidEmail){
//            boolean isValid = emailExample.validate(email);
//            System.out.println("email: "+email+", isValid: "+isValid);
//        }
//    }
    public static void main(String[] args) {
        emailExample= new EmailExample();
        Scanner scanner= new Scanner(System.in);
        System.out.print("nhap Email: ");
        String email = scanner.nextLine();

        boolean isValid= emailExample.validate(email);
        System.out.println("Email: "+email+" vua nhap la "+isValid);
    }
}
