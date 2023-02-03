package test;

public class Cat extends Animal {

    public Cat(String name, String gender) {
        super(name, gender);
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void attack1() {
        System.out.println("800 dame");
    }
}
