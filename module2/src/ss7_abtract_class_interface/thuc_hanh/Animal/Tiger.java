package ss7_abtract_class_interface.thuc_hanh.animal;

public class Tiger extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "tiger: roarrrrr";
    }

    @Override
    public String howToEat() {
        return "could be grilled";
    }
}
