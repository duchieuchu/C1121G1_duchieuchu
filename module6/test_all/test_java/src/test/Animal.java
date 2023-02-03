package test;

public abstract class Animal {
    private String name;
    private String gender;

    public Animal(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void attack() {
        System.out.println("200");
    }

    public abstract void attack1();

}
