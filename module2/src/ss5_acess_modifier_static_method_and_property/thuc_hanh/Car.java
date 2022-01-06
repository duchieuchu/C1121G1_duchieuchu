package ss5_acess_modifier_static_method_and_property.thuc_hanh;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCar;
    public Car(String n, String e) {
        this.name = n;
        this.engine = e;
        numberOfCar++;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public static int getNumberOfCar() {
        return numberOfCar;
    }

    public static void setNumberOfCar(int numberOfCar) {
        Car.numberOfCar = numberOfCar;
    }
//    public void display(){
//        System.out.println(name+" "+engine);
//    }
}
