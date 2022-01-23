package ss11_dsa_stack_queue.optional.kiem_tra_chuoi_palindrome_use_queue;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
//xâu kí tự mà khi viết từ phải qua trái hay từ trái qua phải thì xâu đó không thay đổi.
public class CheckPalindrome {
    public static boolean checkPalindrome(String string){
        String [] stringArray= string.toLowerCase().split("");
        System.out.println(Arrays.toString(stringArray));
        Stack<String >stack= new Stack<>();
        Queue<String> queue= new ArrayDeque<>();
        for (int i = 0;i< stringArray.length;i++){
            stack.push(stringArray[i]);
            queue.add(stringArray[i]);
        }while (!stack.isEmpty()){
            if (!(stack.pop().equals(queue.poll()))){
                return false;
            }
        }return true;
    }
}
