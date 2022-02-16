package ss19_string_regex.thuc_hanh.validate_account;

import java.util.Scanner;

public class AccountExampleTest {
    private static AccountExample accountExample;
//    public static final String[] validAccount= new String[]{"123abc_", "_abc123", "______", "123456","abcdefgh" };
//    public static final String[] inValidAccount = new String[]{ ".@", "12345", "1234_", "abcde"};
//
//    public static void main(String[] args) {
//        accountExample= new AccountExample();
//        for (String account:validAccount
//             ) {
//            boolean isValid= accountExample.validate(account);
//            System.out.println("account: "+account+", isValid: "+isValid);
//        }
//        for (String account:inValidAccount
//        ) {
//            boolean isValid= accountExample.validate(account);
//            System.out.println("account: "+account+", isValid: "+isValid);
//        }
//    }


    public static void main(String[] args) {
        accountExample=new AccountExample();
        Scanner scanner =new Scanner(System.in);
        System.out.print("nhap tai khoan: ");
        String account= scanner.nextLine();

        boolean isValid= accountExample.validate(account);
        System.out.println("tai khoan "+account+" nhap la: "+isValid);
    }
}
