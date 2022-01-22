package ss11_dsa_stack_queue.bai_tap.count_word;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class CountByTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String string = scanner.nextLine();
        string = string.toLowerCase(Locale.ROOT);
        String key ;
        int value =1;
        for (int i = 0 ; i<string.length();i++){
            key = string.substring(i,i+1);
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,value);
            }
        }
        System.out.println(map);
    }
}
