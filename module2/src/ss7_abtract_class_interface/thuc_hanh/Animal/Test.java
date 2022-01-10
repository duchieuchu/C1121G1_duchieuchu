package ss7_abtract_class_interface.thuc_hanh.animal;

public class Test {
    public static void main(String[] args) {
        //animal
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();

        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            } else { Edible edible = (Tiger) animal;
                System.out.println(edible.howToEat());

            }


//            //fruit
//            Fruit[] fruits = new Fruit[2];
//            fruits[0] = new Apple();
//            fruits[1] = new Orange();
//            for (Fruit fruit : fruits) {
//                System.out.println(fruit.howToEat());
//            }
        }
    }
}
