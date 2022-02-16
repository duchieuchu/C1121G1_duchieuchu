package ss19_string_regex.thuc_hanh.crawl_song_list;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try{
            URL url=new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            //mở luồng và đưa nó vào BufferedReader
            Scanner scanner= new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            //dong scanner
            scanner.close();
            //loại bỏ tất cả dòng mới
            content= content.replaceAll("\\n+","");

            Pattern pattern=Pattern.compile("name_song\">(.*?)</a>");
            Matcher matcher= pattern.matcher(content);
            while (matcher.find()){
                System.out.println(matcher.group(1));
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
