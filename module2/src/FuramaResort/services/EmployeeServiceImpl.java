package FuramaResort.services;

import FuramaResort.models.person.Employee;
import FuramaResort.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static final String EMPLOY_PATH = "src/FuramaResort/data/employee.csv";
    List<Employee> employeeList = readCSVFileToEmployeeList(EMPLOY_PATH);//tinh bao dong

    @Override
    public void add() {//dua du lieu tu employeeList vao file SCV/can dung writeFile/chuyen employeeList sang stringList,ủa ko phải mặc định stringlist hả a
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter dayOfBirth: ");
        String dayOfBirth = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter identityCard: ");
        String identityCard = scanner.nextLine();
        System.out.print("Enter numberPhone: ");
        String numberPhone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter educationLevel: ");
        String educationLevel = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter salary: ");
        int salary = Integer.parseInt(scanner.nextLine());

        Employee newEmployee = new Employee(id, name, dayOfBirth, gender, identityCard, numberPhone, email, educationLevel, position, salary);

        WriteFileAndReadFile.writeEmployeeCSVFile(EMPLOY_PATH, newEmployee);
        System.out.println("Successfully added new employee!");
    }

    @Override
    public void display() {//lay du lieu file csv in ra / can readFile/chuyen stringList qua emloyeeList
        employeeList = readCSVFileToEmployeeList(EMPLOY_PATH);//phai co moi dc
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }

    @Override
    public void returnMainMenu() {
        System.out.println("returned main menu");
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id of employee you want to edit: ");
        int idNeedEdit = Integer.parseInt(scanner.nextLine());
        for (Employee employee : employeeList
        ) {
            if (employee.getId() == idNeedEdit) {
                System.out.print("Enter new id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new dayOfBirth: ");
                String dayOfBirth = scanner.nextLine();
                System.out.print("Enter new gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter new identityCard: ");
                String identityCard = scanner.nextLine();
                System.out.print("Enter new numberPhone: ");
                String numberPhone = scanner.nextLine();
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();
                System.out.print("Enter new educationLevel: ");
                String educationLevel = scanner.nextLine();
                System.out.print("Enter new position: ");
                String position = scanner.nextLine();
                System.out.print("Enter new salary: ");
                int salary = Integer.parseInt(scanner.nextLine());
                employee.setId(id);
                employee.setName(name);
                employee.setDayOfBirth(dayOfBirth);
                employee.setGender(gender);
                employee.setIdentityCard(identityCard);
                employee.setNumberPhone(numberPhone);
                employee.setEmail(email);
                employee.setEducationLevel(educationLevel);
                employee.setPosition(position);
                employee.setSalary(salary);
                WriteFileAndReadFile.writeFileListEmployee(EMPLOY_PATH,employeeList);
                break;
            }
        }
    }


    public static List<Employee> readCSVFileToEmployeeList(String pathFile) {
        List<Employee> employeeListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathFile);
        String[] lineSplitList;//muc dich nay de , trong mang

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
