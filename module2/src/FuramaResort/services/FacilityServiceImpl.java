package FuramaResort.services;

import FuramaResort.models.facility.Facility;
import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;
import FuramaResort.utils.WriteFileAndReadFile;


import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    static final String HOUSE_PATH = "src/FuramaResort/data/house.csv";
    static final String ROOM_PATH = "src/FuramaResort/data/room.csv";
    static final String VILLA_PATH = "src/FuramaResort/data/villa.csv";
    static final String FACILITY_PATH = "src/FuramaResort/data/facility.csv";
    List<House> houseList = readCSVFileToHouseList(HOUSE_PATH);
    List<Room> roomList = readCSVFileToRoomList(ROOM_PATH);
    List<Villa> villaList = readCSVFileToVillaList(VILLA_PATH);

    @Override
    public void displayListFacilityMaintenance() {
        Map<Facility, Integer> facilityMaintenanceList = new LinkedHashMap<>();
        Villa villa;
        House house;
        Room room;
        List<String> lineList = WriteFileAndReadFile.readFile(FACILITY_PATH);
        String[] lineSplitList;
        for (String line : lineList) {
            lineSplitList = line.split(",");
            if (Integer.parseInt(lineSplitList[lineSplitList.length - 1]) >= 5) {
                if (lineSplitList[0].contains("id villa")) {
                    villa = new Villa(lineSplitList[0],
                            Double.parseDouble(lineSplitList[1]),
                            Double.parseDouble(lineSplitList[2]),
                            Integer.parseInt(lineSplitList[3]),
                            lineSplitList[4],
                            lineSplitList[5],
                            Double.parseDouble(lineSplitList[6]),
                            Integer.parseInt(lineSplitList[7]));
                    facilityMaintenanceList.put(villa, Integer.parseInt(lineSplitList[8]));
                } else if (line.contains("id house")) {
                    house = new House(lineSplitList[0],
                            Double.parseDouble(lineSplitList[1]),
                            Double.parseDouble(lineSplitList[2]),
                            Integer.parseInt(lineSplitList[3]),
                            lineSplitList[4],
                            lineSplitList[5],
                            Integer.parseInt(lineSplitList[6]));
                    facilityMaintenanceList.put(house, Integer.parseInt(lineSplitList[7]));
                } else if (line.contains("id room")) {
                    room = new Room(lineSplitList[0],
                            Double.parseDouble(lineSplitList[1]),
                            Double.parseDouble(lineSplitList[2]),
                            Integer.parseInt(lineSplitList[3]),
                            lineSplitList[4], lineSplitList[5]);
                    facilityMaintenanceList.put(room, Integer.parseInt(lineSplitList[6]));
                }
            }
        }
        for (Map.Entry<Facility, Integer> entry : facilityMaintenanceList.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
            }
        }

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
            case 1:
                addVilla();
                break;
            case 2:
                addHouse();
                break;
            case 3:
                addRoom();
                break;
            case 4:
                System.out.println("returned main menu");
                break;
        }
    }

    public void addVilla() {//loi ko co dau , trong CSV ko bk do dau
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter serviceName");
        String serviceNameVilla = scanner.nextLine();
        System.out.println("Enter usingArea");
        double usingAreaVilla = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter costRentVilla");
        double costRentVilla = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter personNumber");
        int personNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rentalType");
        String rentalType = scanner.nextLine();

        System.out.println("enter roomStandard");
        String roomStandard = scanner.nextLine();
        System.out.println("enter poolArea");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("enter numberOfFloors");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Villa newVilla = new Villa(serviceNameVilla, usingAreaVilla, costRentVilla,
                personNumber, rentalType, roomStandard, poolArea, numberOfFloors);

        WriteFileAndReadFile.writeVillaCSVFile(VILLA_PATH, newVilla);
        System.out.println("completed");
    }

    public void addHouse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter serviceName");
        String serviceNameHouse = scanner.nextLine();
        System.out.println("Enter usingArea");
        double usingAreaHouse = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter costRentHouse");
        double costRentHouse = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter personNumber");
        int personNumberHouse = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter rentalType");
        String rentalTypeHouse = scanner.nextLine();

        System.out.println("Enter standRoom");
        String standRoom = scanner.nextLine();
        System.out.println("Enter numOfFloor");
        int numOfFloor = Integer.parseInt(scanner.nextLine());
        House newHouse = new House(serviceNameHouse, usingAreaHouse, costRentHouse, personNumberHouse,
                rentalTypeHouse, standRoom, numOfFloor);

        WriteFileAndReadFile.writeHouseSCVFile(HOUSE_PATH, newHouse);
        System.out.println("completed");
    }

    public void addRoom() {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("completed");
    }

    @Override
    public void display() {
        houseList = readCSVFileToHouseList(HOUSE_PATH);
        for (int i = 0; i < houseList.size(); i++) {
            System.out.println(houseList.get(i));
        }
        roomList = readCSVFileToRoomList(ROOM_PATH);
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println(roomList.get(i));
        }
        villaList = readCSVFileToVillaList(VILLA_PATH);
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
                    lineSpitList[4],
                    lineSpitList[5],
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

        for (String line : lineList) {
            lineSpitLit = line.split(",");
            villaListFromReadCSV.add(new Villa(lineSpitLit[0],
                    Double.parseDouble(lineSpitLit[1]),
                    Double.parseDouble(lineSpitLit[2]),
                    Integer.parseInt(lineSpitLit[3]),
                    lineSpitLit[4],
                    lineSpitLit[5],
                    Double.parseDouble(lineSpitLit[6]),
                    Integer.parseInt(lineSpitLit[7])));
        }
        return villaListFromReadCSV;
    }
}
