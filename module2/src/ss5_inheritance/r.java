package ss5_inheritance;

public class r {
    public void makeSound() {
        System.out.println("Động vật kêu");
    }
}

class Pig extends r {
    public void makeSound() {
        System.out.println("The pig says: ủn ỉn");
    }
}

class Dog extends r {
    public void makeSound() {
        System.out.println("The dog says: gâu gâu");
    }
}


class MyMainClass {
    public static void main(String[] args) {
        r myAnimal = new r();
        r myPig = new Pig();
        r myDog = new Dog();
        myAnimal.makeSound(); //lúc này sẽ in ra là ("Động vật kêu")
        myPig.makeSound(); // lúc này sẽ in ra là ("The pig says: ủn ỉn");
        myDog.makeSound();// luc này sẽ in là là ("The dog says: gâu gâu")
    }

}
