package ss10_dsa_list.bai_tap;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> elementsArray = new MyList<Integer>();
        elementsArray.add(0, 1);
        elementsArray.add(1, 2);
        elementsArray.add(2, 3);
        elementsArray.add(3, 4);
        elementsArray.add(4, 5);
        System.out.println("current size: " + elementsArray.size());
        System.out.println(elementsArray.get(0));
        System.out.println(elementsArray.get(1));
        System.out.println(elementsArray.get(2));
        System.out.println(elementsArray.get(3));
        System.out.println(elementsArray.get(4));

    }
}
