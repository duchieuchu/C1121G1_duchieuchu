package FuramaResortFake.services.impl;

import FuramaResortFake.models.facility.Facility;
import FuramaResortFake.models.facility.House;
import FuramaResortFake.models.facility.Room;
import FuramaResortFake.models.facility.Villa;
import FuramaResortFake.services.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayListFacilityMaintenance() {

    }

    @Override
    public void addVilla() {
        System.out.print("enter idService: ");
        String idService = scanner.nextLine();
        System.out.print("enter serviceName: ");
        String serviceName = scanner.nextLine();
        System.out.print("enter UsingArea: ");
        double usingArea = Double.parseDouble(scanner.nextLine());
        System.out.print("enter costRent: ");
        double costRent = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfPeople: ");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("enter rentalType: ");
        String rentalType = scanner.nextLine();
        System.out.print("enter roomStandard: ");
        String roomStandard = scanner.nextLine();
        System.out.print("enter poolArea: ");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfFloors: ");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());

        Villa villa = new Villa(idService, serviceName, usingArea, costRent, numberOfPeople,
                rentalType, roomStandard, poolArea, numberOfFloors);
        facilityIntegerMap.put(villa, 0);
        System.out.println("COMPLETED!");


    }

    @Override
    public void addRoom() {
        System.out.print("enter idService: ");
        String idService = scanner.nextLine();
        System.out.print("enter serviceName: ");
        String serviceName = scanner.nextLine();
        System.out.print("enter UsingArea: ");
        double usingArea = Double.parseDouble(scanner.nextLine());
        System.out.print("enter costRent: ");
        double costRent = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfPeople: ");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("enter rentalType: ");
        String rentalType = scanner.nextLine();
        System.out.print("enter freeService: ");
        String freeService = scanner.nextLine();

        Room room = new Room(idService, serviceName, usingArea, costRent, numberOfPeople, rentalType, freeService);
        facilityIntegerMap.put(room, 0);
        System.out.println("COMPLETED!");

    }

    @Override
    public void addHouse() {
        System.out.print("enter idService: ");
        String idService = scanner.nextLine();
        System.out.print("enter serviceName: ");
        String serviceName = scanner.nextLine();
        System.out.print("enter UsingArea: ");
        double usingArea = Double.parseDouble(scanner.nextLine());
        System.out.print("enter costRent: ");
        double costRent = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfPeople: ");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("enter rentalType: ");
        String rentalType = scanner.nextLine();
        System.out.print("enter roomStandard: ");
        String roomStandard = scanner.nextLine();
        System.out.print("enter numberOfFloor: ");
        int numberOfFloor = Integer.parseInt(scanner.nextLine());

        House house = new House(idService, serviceName, usingArea, costRent, numberOfPeople, rentalType,
                roomStandard, numberOfFloor);
        facilityIntegerMap.put(house, 0);
        System.out.println("COMPLETED!");


    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + "so lan thue: " + element.getValue());
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void edit() {

    }
}
