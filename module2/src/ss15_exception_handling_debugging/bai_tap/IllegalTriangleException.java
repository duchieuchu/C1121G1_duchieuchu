package ss15_exception_handling_debugging.bai_tap;
//nhập vào 3 cạnh của hình tam giác.
// Kiểm tra nếu giá trị nhập vào là số âm hoặc tổng 2 cạnh không lớn hơn cạnh còn lại thì sinh ngoại lệ.
public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(){

    }
    public IllegalTriangleException(String errorInputSide){
        super(errorInputSide);

    }

}
