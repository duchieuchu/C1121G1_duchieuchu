package FuramaResort.services;

import FuramaResort.models.person.Employee;
import FuramaResort.utils.WriteFileAndReadFile;
import ss16_io_text_file.thuc_hanh.find_max_value.ReadAndWriteFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static final String EMPLOY_PATH = "src/FuramaResort/data/employee.csv";
     List<Employee> employeeList = readCSVFileToEmployeeList(EMPLOY_PATH);//tinh bao dong

    @Override
    public void add() {//dua du lieu tu employeeList vao file SCV/can dung writeFile/chuyen employeeList sang stringList,ủa ko phải mặc định stringlist hả a
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter dayOfBirth: ");
        String dayOfBirth = scanner.nextLine();
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter identityCard: ");
        String identityCard = scanner.nextLine();
        System.out.println("Enter numberPhone: ");
        String numberPhone = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter educationLevel: ");
        String educationLevel = scanner.nextLine();
        System.out.println("Enter position: ");
        String position = scanner.nextLine();
        System.out.println("Enter salary: ");
        int salary= Integer.parseInt(scanner.nextLine());

        Employee newEmployee = new Employee(id, name, dayOfBirth, gender, identityCard, numberPhone, email, educationLevel, position, salary);
//        employeeList.add(newEmployee.getInformationEmployee());

        WriteFileAndReadFile.writeFile(EMPLOY_PATH,newEmployee);
        System.out.println("Successfully added new employee!");
    }

    @Override
    public void display() {//lay du lieu file csv in ra / can readFile/chuyen stringList qua emloyeeList
        List<Employee> employeeList = new ArrayList<>();
        employeeList = readCSVFileToEmployeeList("src/FuramaResort/data/employee.csv");
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }

    @Override
    public void returnMainMenu() {

    }

    @Override
    public void edit() {

    }

    public static void writeEmployeeListToCSVFile(String path, List<Employee> employeeList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList
        ) {
            stringList.add(employee.writeToSCVFile());
        }

    }

    public static List<Employee> readCSVFileToEmployeeList(String pathFile) {
        List<Employee> employeeListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathFile);
        String[] lineSplitList;

        for (String line : lineList) {
            lineSplitList = line.split(",");
            employeeListFromReadCSV.add(new Employee(Integer.parseInt(lineSplitList[0]),
                    lineSplitList[1],
                    lineSplitList[2],
                    lineSplitList[3],
                    lineSplitList[4],
                    lineSplitList[5],
                    lineSplitList[6],
                    lineSplitList[7],
                    lineSplitList[8],
                    Integer.parseInt(lineSplitList[9])));
        }
        return employeeListFromReadCSV;
    }
}
