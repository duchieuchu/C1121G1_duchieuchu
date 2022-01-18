package ss13_seacrhing_algorithms.thuc_hanh;

public class BinarySearch {
    static int[] list = {2, 4, 7, 9, 22, 55, 77, 99};

//    static int linearSearch(int[] list, int value) {
//        for (int i = 0; i < list.length; i++) {
//            if (list[i] == value) {
//                return i;
//            }
//        }
//        return -1;
//    }

    static int binarySearch(int[] list, int value) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (value < list[mid])
                high = mid - 1;
            else if (value == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 4));
        System.out.println(binarySearch(list, 7));
        System.out.println(binarySearch(list, 9));
        System.out.println(binarySearch(list, 22));
        System.out.println(binarySearch(list, 55));
        System.out.println(binarySearch(list, 77));
        System.out.println(binarySearch(list, 99));
        System.out.println(binarySearch(list, 11));
//        System.out.println(linearSearch(list, 2));
//        System.out.println(linearSearch(list, 4));
//        System.out.println(linearSearch(list, 7));
//        System.out.println(linearSearch(list, 9));
//        System.out.println(linearSearch(list, 22));
//        System.out.println(linearSearch(list, 55));
//        System.out.println(linearSearch(list, 77));
//        System.out.println(linearSearch(list, 99));
//        System.out.println(linearSearch(list, 11));

    }
}
