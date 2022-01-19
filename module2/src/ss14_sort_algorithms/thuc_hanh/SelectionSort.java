package ss14_sort_algorithms.thuc_hanh;

public class SelectionSort {
    static double list[] = {5, 1, -4, -11, 9, 6, 8, 4.1, 1.2};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            //tim gia tri nho nhat trong ds
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
//swap list [i] voi list[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (int i =0;i< list.length;i++){
            System.out.println(list[i]+" ");
        }
    }
}


