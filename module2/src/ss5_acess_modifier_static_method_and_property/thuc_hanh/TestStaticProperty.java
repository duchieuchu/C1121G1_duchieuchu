package ss5_acess_modifier_static_method_and_property.thuc_hanh;

public class TestStaticProperty {
    public static void main(String[] args) {

        Car car1= new Car("Lamborghini Aventador","\t6.5 L L539 V12");
        System.out.println(Car.numberOfCar);
        Car car2= new Car("Ferrari 488","\t3.9 L F154 CB twin-turbocharged V8");
        System.out.println(Car.numberOfCar);

//        car1.display();
//        car2.display();
    }
}
