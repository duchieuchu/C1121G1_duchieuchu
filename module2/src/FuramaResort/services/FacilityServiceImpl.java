package FuramaResort.services;

import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;
import FuramaResort.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    static final String HOUSE_PATH = "src/FuramaResort/data/house.csv";
    static final String ROOM_PATH = "src/FuramaResort/data/room.csv";
    static final String VILLA_PATH = "src/FuramaResort/data/villa.csv";
    List<House> houseList = readCSVFileToHouseList(HOUSE_PATH);
    List<Room> roomList = readCSVFileToRoomList(ROOM_PATH);
    List<Villa> villaList = readCSVFileToVillaList(VILLA_PATH);

    @Override
    public void displayListFacilityMaintenance() {

    }

    @Override
    public void add() {
        System.out.println("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose) {
            case 1: System.out.println("Enter serviceName: ");
                String serviceName = scanner.nextLine();
                System.out.println("Enter usingArea: ");
                double usingArea = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter costRent: ");
                double costRent = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter personNumber: ");
                int personNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter rentalType: ");
                String rentalType = scanner.nextLine();
                System.out.println("Enter roomStandard: ");
                String roomStandard = scanner.nextLine();
                System.out.println("Enter poolArea: ");
                double poolArea = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter numberOfFloors: ");
                int numOfFloors = Integer.parseInt(scanner.nextLine());
                Villa newVilla = new Villa(serviceName, usingArea, costRent, personNumber,
                        rentalType, roomStandard, poolArea, numOfFloors);

                WriteFileAndReadFile.writeVillaCSVFile(VILLA_PATH, newVilla);
                System.out.println("Successfully added new villa!");
                break;
            case 2:
                System.out.println("Enter serviceName: ");
                String serviceNameHouse = scanner.nextLine();
                System.out.println("Enter usingArea: ");
                double usingAreaHouse = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter costRent: ");
                double costRentHouse = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter personNumber: ");
                int personNumberHouse = scanner.nextInt();
                System.out.println("Enter rentalType: ");
                String rentalTypeHouse = scanner.nextLine();
                System.out.println("Enter standardRoom: ");
                String standardRoom = scanner.nextLine();
                System.out.println("Enter numberOfFloors: ");
                int numberOfFloors = Integer.parseInt(scanner.nextLine());
                House newHouse = new House(serviceNameHouse, usingAreaHouse, costRentHouse,
                        personNumberHouse, rentalTypeHouse, serviceNameHouse, numberOfFloors);

                WriteFileAndReadFile.writeHouseCSVFile(HOUSE_PATH, newHouse);
                System.out.println("Successfully added new house!");
                break;
            case 3:
                System.out.println("Enter serviceName");
                String serviceNameRoom = scanner.nextLine();
                System.out.println("Enter usingArea");
                double usingAreaRoom = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter costRent");
                double costRentRoom = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter personNumber");
                int personNumberRoom = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter rentalType");
                String rentalTypeRoom = scanner.nextLine();
                System.out.println("Enter freeService");
                String freeService = scanner.nextLine();
                Room newRoom = new Room(serviceNameRoom, usingAreaRoom, costRentRoom,
                        personNumberRoom, rentalTypeRoom, freeService);
                WriteFileAndReadFile.writeRoomCSVFile(ROOM_PATH, newRoom);
                System.out.println("Successfully added new room!");
                break;
            case 4:
                System.out.println("returned main menu");
                break;
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < houseList.size(); i++) {
            System.out.println(houseList.get(i));
        }
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println(roomList.get(i));
        }
        for (int i = 0; i < villaList.size(); i++) {
            System.out.println(villaList.get(i));
        }
    }

    @Override
    public void returnMainMenu() {
        System.out.println("returned main menu");
    }

    @Override
    public void edit() {

    }

    public static List<House> readCSVFileToHouseList(String pathLine) {
        List<House> houseListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathLine);
        String[] lineSpitList;

        for (String line : lineList) {
            lineSpitList = line.split(",");
            houseListFromReadCSV.add(new House(lineSpitList[0],
                    Double.parseDouble(lineSpitList[1]),
                    Double.parseDouble(lineSpitList[2]),
                    Integer.parseInt(lineSpitList[3]),
                    lineSpitList[4], lineSpitList[5],
                    Integer.parseInt(lineSpitList[6])));
        }
        return houseListFromReadCSV;
    }

    public static List<Room> readCSVFileToRoomList(String pathLine) {
        List<Room> roomListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathLine);
        String[] lineSpitLit;

        for (String line : lineList) {
            lineSpitLit = line.split(",");
            roomListFromReadCSV.add(new Room(lineSpitLit[0],
                    Double.parseDouble(lineSpitLit[1]),
                    Double.parseDouble(lineSpitLit[2]),
                    Integer.parseInt(lineSpitLit[3]),
                    lineSpitLit[4], lineSpitLit[5]));
        }
        return roomListFromReadCSV;
    }

    public static List<Villa> readCSVFileToVillaList(String pathLine) {
        List<Villa> villaListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathLine);
        String[] lineSpitLit;
        try {
            for (String line : lineList) {
                lineSpitLit = line.split(",");
                villaListFromReadCSV.add(new Villa(lineSpitLit[0],
                        Double.parseDouble(lineSpitLit[1]),
                        Double.parseDouble(lineSpitLit[2]),
                        Integer.parseInt(lineSpitLit[3]),
                        lineSpitLit[4], lineSpitLit[5],
                        Double.parseDouble(lineSpitLit[6]),
                        Integer.parseInt(lineSpitLit[7])));

            }
        } catch (Exception e) {
            System.out.println("loi");
        }
        return villaListFromReadCSV;
    }
}
