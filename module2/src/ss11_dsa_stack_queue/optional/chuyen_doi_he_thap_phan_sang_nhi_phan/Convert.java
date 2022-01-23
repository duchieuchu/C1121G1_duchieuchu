package ss11_dsa_stack_queue.optional.chuyen_doi_he_thap_phan_sang_nhi_phan;

import java.util.Stack;

public class Convert {
    public String convertFromDecimalToBinary(int number) {
        Stack<Integer> stack = new Stack<>();
        String string = "";
        while (number > 0) {
            int a = number % 2;//Chuyển đổi số từ dạng thập phân sang nhị phân bằng phép chia lấy dư cho 2.
            stack.push(a);// Kết quả của phép chia được đưa vào Stack.
            number = number / 2;
        }
        while (!stack.isEmpty()) {// Đọc từ Stack cho đến hết, kết quả được nối với nhau để tạo thành chuỗi.
            string += stack.peek();
            stack.pop();
        }
        return string;
    }

}
