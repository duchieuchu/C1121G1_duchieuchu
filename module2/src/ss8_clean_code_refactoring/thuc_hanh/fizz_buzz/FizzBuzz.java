package ss8_clean_code_refactoring.thuc_hanh.fizz_buzz;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isBuzz && isFizz)
            return "FizzBuzz";
        else if (isFizz)
            return "isFizz";
        else
            return "isBuzz";

//        return number + "";
    }
}
