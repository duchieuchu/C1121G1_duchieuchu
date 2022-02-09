package FuramaResort.services;

import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;
import FuramaResort.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;

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

    }

    @Override
    public void display() {
        for (int i = 0; i < houseList.size(); i++) {
            System.out.println(houseList.get(i));
        }
        for (int i = 0;i<roomList.size();i++){
            System.out.println(roomList.get(i));
        }
        for (int i = 0;i<villaList.size();i++){
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
        return villaListFromReadCSV;
    }
}
