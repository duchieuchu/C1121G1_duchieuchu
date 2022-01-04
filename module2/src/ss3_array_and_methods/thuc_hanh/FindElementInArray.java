package ss3_array_and_methods.thuc_hanh;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.sound.sampled.Line;
import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        String[] students = {"lan", "hoa", "thuy", "linh"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name's student");
        String input_name = scanner.nextLine();
        boolean isExit = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("position of " + input_name + " in the list " + " is :" + i);
                isExit = true;
                break;
            }
        }
        if (!isExit) {
            System.out.println("not found " + input_name + " in the list");
        }
    }
}
