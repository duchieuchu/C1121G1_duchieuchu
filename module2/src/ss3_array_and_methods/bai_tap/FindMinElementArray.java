package ss3_array_and_methods.bai_tap;

public class FindMinElementArray {
    public static void main(String[] args) {
        int[] arr = {2, 22, 1, 33, 11};
        int min = minValue(arr);
        System.out.println("the smallest element in the array is: " + arr[min]);
    }

    public static int minValue(int[] array) {
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }
}

