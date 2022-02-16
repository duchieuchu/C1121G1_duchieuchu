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
    List<Facility> facilityList = readCSVFileToFacilityList(FACILITY_PATH);

    @Override
    public void displayListFacilityMaintenance() {
//        Map<Facility, Integer> facilityMaintenanceList = new LinkedHashMap<>();
//        Villa villa;
//        House house;
//        Room room;
//        List<String> lineList = WriteFileAndReadFile.readFile(FACILITY_PATH);
//        String[] lineSplitList;
//        for (String line : lineList) {
//            lineSplitList = line.split(",");
//            if (Integer.parseInt(lineSplitList[lineSplitList.length - 1]) >= 5) {
//                if (lineSplitList[0].contains("id villa")) {
//                    villa = new Villa(lineSplitList[0], lineSplitList[1],
//                            Double.parseDouble(lineSplitList[2]),
//                            Double.parseDouble(lineSplitList[3]),
//                            Integer.parseInt(lineSplitList[4]),
//                            lineSplitList[5],
//                            lineSplitList[6],
//                            Double.parseDouble(lineSplitList[7]),
//                            Integer.parseInt(lineSplitList[8]));
//                    facilityMaintenanceList.put(villa, Integer.parseInt(lineSplitList[9]));
//                } else if (line.contains("id house")) {
//                    house = new House(lineSplitList[0], lineSplitList[1],
//                            Double.parseDouble(lineSplitList[2]),
//                            Double.parseDouble(lineSplitList[3]),
//                            Integer.parseInt(lineSplitList[4]),
//                            lineSplitList[5],
//                            lineSplitList[6],
//                            Integer.parseInt(lineSplitList[7]));
//                    facilityMaintenanceList.put(house, Integer.parseInt(lineSplitList[8]));
//                } else if (line.contains("id room")) {
//                    room = new Room(lineSplitList[0], lineSplitList[1],
//                            Double.parseDouble(lineSplitList[2]),
//                            Double.parseDouble(lineSplitList[3]),
//                            Integer.parseInt(lineSplitList[4]),
//                            lineSplitList[5], lineSplitList[6]);
//                    facilityMaintenanceList.put(room, Integer.parseInt(lineSplitList[7]));
//                }
//            }
//        }
//        for (Map.Entry<Facility, Integer> entry : facilityMaintenanceList.entrySet()) {
//            if (entry.getValue() >= 5) {
//                System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
//            }
//        }
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
        System.out.print("Enter idFacility");
        String idFacility = scanner.nextLine();
        System.out.print("Enter serviceName");
        String serviceNameVilla = scanner.nextLine();
        System.out.print("Enter usingArea");
        double usingAreaVilla = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter costRentVilla");
        double costRentVilla = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter personNumber");
        int personNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter rentalType");
        String rentalType = scanner.nextLine();

        System.out.print("enter roomStandard");
        String roomStandard = scanner.nextLine();
        System.out.print("enter poolArea");
        double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.print("enter numberOfFloors");
        int numberOfFloors = Integer.parseInt(scanner.nextLine());
        Villa newVilla = new Villa(idFacility, serviceNameVilla, usingAreaVilla, costRentVilla,
                personNumber, rentalType, roomStandard, poolArea, numberOfFloors);

        WriteFileAndReadFile.writeVillaCSVFile(VILLA_PATH,FACILITY_PATH, newVilla);
        System.out.println("completed");
    }

    public void addHouse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter idFacility ");
        String idFacility = scanner.nextLine();
        System.out.print("Enter serviceName");
        String serviceNameHouse = scanner.nextLine();
        System.out.print("Enter usingArea");
        double usingAreaHouse = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter costRentHouse");
        double costRentHouse = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter personNumber");
        int personNumberHouse = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter rentalType");
        String rentalTypeHouse = scanner.nextLine();

        System.out.print("Enter standRoom");
        String standRoom = scanner.nextLine();
        System.out.print("Enter numOfFloor");
        int numOfFloor = Integer.parseInt(scanner.nextLine());
        House newHouse = new House(idFacility, serviceNameHouse, usingAreaHouse, costRentHouse, personNumberHouse,
                rentalTypeHouse, standRoom, numOfFloor);

        WriteFileAndReadFile.writeHouseSCVFile(HOUSE_PATH,FACILITY_PATH, newHouse);
        System.out.println("completed");
    }

    public void addRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter idFacility  ");
        String idFacility = scanner.nextLine();
        System.out.print("Enter serviceName");
        String serviceNameRoom = scanner.nextLine();
        System.out.print("Enter usingArea");
        double usingAreaRoom = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter costRent");
        double costRentRoom = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter personNumber");
        int personNumberRoom = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter rentalType");
        String rentalTypeRoom = scanner.nextLine();

        System.out.print("Enter freeService");
        String freeService = scanner.nextLine();
        Room newRoom = new Room(idFacility, serviceNameRoom, usingAreaRoom, costRentRoom,
                personNumberRoom, rentalTypeRoom, freeService);

        WriteFileAndReadFile.writeRoomCSVFile(ROOM_PATH,FACILITY_PATH, newRoom);
        System.out.println("completed");
    }

    @Override
    public void display() {
        facilityList=readCSVFileToFacilityList(FACILITY_PATH);
        for (int i= 0;i<facilityList.size();i++){
            System.out.println(facilityList.get(i));
        }
//        villaList = readCSVFileToVillaList(VILLA_PATH);
//        for (int i = 0; i < villaList.size(); i++) {
//            System.out.println(villaList.get(i));
//        }
//        houseList = readCSVFileToHouseList(HOUSE_PATH);
//        for (int i = 0; i < houseList.size(); i++) {
//            System.out.println(houseList.get(i));
//        }
//        roomList = readCSVFileToRoomList(ROOM_PATH);
//        for (int i = 0; i < roomList.size(); i++) {
//            System.out.println(roomList.get(i));
//        }
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
        String[] lineSplitList;

        for (String line : lineList) {
            lineSplitList = line.split(",");
            houseListFromReadCSV.add(new House(lineSplitList[0], lineSplitList[1],
                    Double.parseDouble(lineSplitList[2]),
                    Double.parseDouble(lineSplitList[3]),
                    Integer.parseInt(lineSplitList[4]),
                    lineSplitList[5],
                    lineSplitList[6],
                    Integer.parseInt(lineSplitList[7])));
        }
        return houseListFromReadCSV;
    }

    public static List<Room> readCSVFileToRoomList(String pathLine) {
        List<Room> roomListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathLine);
        String[] lineSplitList;

        for (String line : lineList) {
            lineSplitList = line.split(",");
            roomListFromReadCSV.add(new Room(lineSplitList[0], lineSplitList[1],
                    Double.parseDouble(lineSplitList[2]),
                    Double.parseDouble(lineSplitList[3]),
                    Integer.parseInt(lineSplitList[4]),
                    lineSplitList[5], lineSplitList[6]));
        }
        return roomListFromReadCSV;
    }

    public static List<Villa> readCSVFileToVillaList(String pathLine) {
        List<Villa> villaListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathLine);
        String[] lineSplitList;

        for (String line : lineList) {
            lineSplitList = line.split(",");
            villaListFromReadCSV.add(new Villa(lineSplitList[0], lineSplitList[1],
                    Double.parseDouble(lineSplitList[2]),
                    Double.parseDouble(lineSplitList[3]),
                    Integer.parseInt(lineSplitList[4]),
                    lineSplitList[5],
                    lineSplitList[6],
                    Double.parseDouble(lineSplitList[7]),
                    Integer.parseInt(lineSplitList[8])));
        }
        return villaListFromReadCSV;
    }

    public static List<Facility> readCSVFileToFacilityList(String pathLine) {
        List<Facility> facilityListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathLine);
        String[] lineSplitList;

        for (String line : lineList) {
            lineSplitList = line.split(",");
            if (lineSplitList[0].contains("SVVL")) {
                facilityListFromReadCSV.add(new Villa(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]),
                        Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]),
                        lineSplitList[5],
                        lineSplitList[6],
                        Double.parseDouble(lineSplitList[7]),
                        Integer.parseInt(lineSplitList[8])));
            } else if (lineSplitList[0].contains("SVHO")) {
                facilityListFromReadCSV.add(new House(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]),
                        Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]),
                        lineSplitList[5],
                        lineSplitList[6],
                        Integer.parseInt(lineSplitList[7])));
            } else if (lineSplitList[0].contains("SVRO")) {
                facilityListFromReadCSV.add(new Room(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]),
                        Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]),
                        lineSplitList[5], lineSplitList[6]));
            }
        }
        return facilityListFromReadCSV;
    }
}
