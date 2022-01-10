package ss7_abtract_class_interface.thuc_hanh.animal;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "chicken: cuc cac";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
