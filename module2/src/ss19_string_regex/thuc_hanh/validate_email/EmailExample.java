package ss19_string_regex.thuc_hanh.validate_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
   //Bắt đầu bằng một ký tự
   //Không chứa các ký tự đặc biệt
   //Có một ký tự @ ngăn cách tên email và domain
   //Domain phải hợp lệ
    private static Pattern pattern;
    private Matcher matcher;//kiểm tra xem biểu thức chính quy có khớp với mẫu hay không.

    private static final String EMAIL_REGEX="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailExample(){
        pattern =Pattern.compile(EMAIL_REGEX);//biên dịch regex đã cho và trả về thể hiện của Pattern.
    }
    public boolean validate(String regex){//pt check
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
