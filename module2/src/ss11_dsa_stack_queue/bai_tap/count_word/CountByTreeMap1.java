package ss11_dsa_stack_queue.bai_tap.count_word;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountByTreeMap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string");
        String string = scanner.nextLine();
        String newString= string.toLowerCase().replaceAll(",","");
        String []arr = newString.split(" ");

        String key="" ;//mỗi từ được lấy ra từ chuỗi là 1 key.
        Integer value= 1;
        TreeMap<String,Integer>map= new TreeMap<String,Integer>();
        for (int i = 0;i<arr.length;i++){
            key = arr[i];
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,value);
            }
        }
        Set set = map.keySet();
        Iterator iterator= set.iterator();
        while (iterator.hasNext()){
            key= (String) iterator.next();
            System.out.println("từ "+key+" xuất hiện "+map.get(key)+" lần");
        }
    }
}
