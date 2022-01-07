package ss5_inheritance.thuc_hanh;

public class TestSquare {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(3.7);
        System.out.println(square);

        square= new Square(3.2,"yellow",true);
        System.out.println(square);
    }
}
