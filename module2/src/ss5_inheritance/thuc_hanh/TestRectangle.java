package ss5_inheritance.thuc_hanh;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle= new Rectangle(3.5,7);
        System.out.println(rectangle);

        rectangle = new Rectangle(3.7, 5.9, "Blue", true);
        System.out.println(rectangle);
    }
}
