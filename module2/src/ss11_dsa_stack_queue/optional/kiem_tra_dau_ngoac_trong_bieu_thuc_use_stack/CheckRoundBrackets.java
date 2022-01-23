package ss11_dsa_stack_queue.optional.kiem_tra_dau_ngoac_trong_bieu_thuc_use_stack;

import java.util.Arrays;
import java.util.Stack;
//Kiểm tra dấu ngoặc trong biểu thức
public class CheckRoundBrackets {
    public boolean checkRoundBrackets(String string) {
//        string = "s * (s – a) * (s – b) * (s – c)";
        String[] array = string.split("");
        System.out.println(Arrays.toString(array));
        Stack< String > bStack = new Stack<>();
        boolean check = true;
        String left;
        int count1 =0;
        int count2 =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(")) {
                bStack.push(array[i]);
                count1++;
            }
            if (array[i].equals(")")) {
                count2++;
                if (bStack.empty()) {
                    check = false;
                } else if (bStack.peek().equals(array[i])) {
                    check = true;
                    bStack.pop();
//                } else {
//                    check = false;
                }
            }
        }
        if (check && count1==count2) {
            return true;
        } else {
            return false;
        }
    }
}
