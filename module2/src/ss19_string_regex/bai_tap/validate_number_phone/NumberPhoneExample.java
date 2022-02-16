package ss19_string_regex.bai_tap.validate_number_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhoneExample {
    //Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx`)
    //
    //x là ký tự số
    //
    //Không chứa các ký tự đặc biệt
    //
    //Ví dụ số điện thoại hợp lệ: (84)-(0978489648)
    //
    //Ví dụ tên lớp không hợp lệ: (a8)-(22222222)
    private static final String NUMBERPHONE_REGEX = "^[(]\\d{2}[)][-][(][0]\\d{9}[)]$";

    public NumberPhoneExample(){

    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(NUMBERPHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
