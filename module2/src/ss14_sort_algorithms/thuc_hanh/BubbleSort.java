package ss14_sort_algorithms.thuc_hanh;

public class BubbleSort {
    static  int []list={9,11,7,5,4,2,1,6,};
    public static void bubbleSort(int[] list){
        boolean needNeedPass= true;
        for (int k = 1;k< list.length&&needNeedPass;k++){
            needNeedPass= false;
            for (int i = 0;i< list.length-k;i++){
                if (list[i]>list[i+1]){
                    int temp =list[i];
                    list[i]=list[i+1];
                    list[i+1]=temp;
                    needNeedPass= true;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0;i< list.length;i++){
            System.out.println(list[i]+" ");
        }
    }

}
