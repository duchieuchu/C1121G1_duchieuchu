package ss16_io_text_file.thuc_hanh.sum_of_numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);

            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println("Tổng = " + sum);
            br.close();

            // Hiển thị ra màn hình tổng các số nguyên trong file
//            System.out.println("Tổng = " + sum);
        } catch (Exception e) {//e la tham so dai dien cho exception
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }

    public static void main(String[] args) {
//        System.out.println("src/ss16_io_text_file/data/file numbersToSum.txt");
//        Scanner scanner = new Scanner(System.in);
//        String path = scanner.nextLine();

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText("src/ss16_io_text_file/data/file numbersToSum.txt");
    }
}

