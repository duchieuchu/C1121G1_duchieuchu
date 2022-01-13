package ss11_dsa_stack_queue.bai_tap.reserve_elements_array_use_stack;

import java.util.Arrays;

import static ss11_dsa_stack_queue.bai_tap.reserve_elements_array_use_stack.Reserve.reverseInterger;
import static ss11_dsa_stack_queue.bai_tap.reserve_elements_array_use_stack.Reserve.reverseString;

public class MainOfReserve {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseInterger(array);
        System.out.println(Arrays.toString(array));
        String string = "a,b,c,d,e,f,g,h";
        System.out.println(reverseString(string));
    }

}
