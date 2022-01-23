package ss11_dsa_stack_queue.optional.kiem_tra_dau_ngoac_trong_bieu_thuc_use_stack;

public class CheckRoundBracketsTest {
    public static void main(String[] args) {
        CheckRoundBrackets check = new CheckRoundBrackets();
        System.out.println(check.checkRoundBrackets("s * (s – a) * (s – b) * (s – c) "));
        System.out.println(check.checkRoundBrackets("(– b + (b2 – 4*a*c)^0.5) / 2*a  "));
        System.out.println(check.checkRoundBrackets("s * (s – a) * (s – b * (s – c)   "));
        System.out.println(check.checkRoundBrackets("s * (s – a) * s – b) * (s – c)      "));
        System.out.println(check.checkRoundBrackets("(– b + (b^2 – 4*a*c)^(0.5/ 2*a))"));
        System.out.println(check.checkRoundBrackets("(a+b))"));
        System.out.println(check.checkRoundBrackets("(a+b)"));
        System.out.println(check.checkRoundBrackets("(a+b"));

        System.out.println(check.checkRoundBrackets("chu.duc/hieu"));
    }
}
