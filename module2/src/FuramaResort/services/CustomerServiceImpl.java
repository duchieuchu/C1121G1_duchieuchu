package FuramaResort.services;

import FuramaResort.models.person.Customer;
import FuramaResort.models.person.Employee;
import FuramaResort.utils.WriteFileAndReadFile;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    static final String CUSTOMER_PATH = "src/FuramaResort/data/customer.csv";
    List<Customer> customerList = readFileCSVToCustomerList(CUSTOMER_PATH);

    @Override
    public void add() {
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
        System.out.println("Enter typeCustomer: ");
        String typeCustomer = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, dayOfBirth, gender, identityCard, numberPhone, email, typeCustomer, address);

        WriteFileAndReadFile.writeCustomerSCVFile(CUSTOMER_PATH, newCustomer);
        System.out.println("Successfully added new customer");
    }

    @Override
    public void display() {
        customerList = readFileCSVToCustomerList("src/FuramaResort/data/customer.csv");
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i));
        }
    }

    @Override
    public void returnMainMenu() {
        System.out.println("returned main menu");
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id of customer you want to edit");
        int idNeedEdit = Integer.parseInt(scanner.nextLine());
        for (Customer customer : customerList
        ) {
            if (customer.getId() == idNeedEdit) {
                System.out.println("Enter new id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                System.out.println("Enter new dayOfBirth: ");
                String dayOfBirth = scanner.nextLine();
                System.out.println("Enter new gender: ");
                String gender = scanner.nextLine();
                System.out.println("Enter new identityCard: ");
                String identityCard = scanner.nextLine();
                System.out.println("Enter new numberPhone: ");
                String numberPhone = scanner.nextLine();
                System.out.println("Enter new email: ");
                String email = scanner.nextLine();
                System.out.println("Enter typeCustomer: ");
                String typeCustomer = scanner.nextLine();
                System.out.println("Enter address: ");
                String address = scanner.nextLine();
                customer.setId(id);
                customer.setName(name);
                customer.setDayOfBirth(dayOfBirth);
                customer.setGender(gender);
                customer.setIdentityCard(identityCard);
                customer.setNumberPhone(numberPhone);
                customer.setEmail(email);
                customer.setTypeCustomer(typeCustomer);
                customer.setAddress(address);
                WriteFileAndReadFile.writeFileListCustomer(CUSTOMER_PATH, customerList);//customerList tren cung
                break;
            }

        }

    }

    public static List<Customer> readFileCSVToCustomerList(String pathFiLe) {
        List<Customer> customerListFromReadCSV = new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathFiLe);//readFile nua
        String[] lineSlitList;

        for (String line : lineList
        ) {
            lineSlitList = line.split(",");
            customerListFromReadCSV.add(new Customer(Integer.parseInt(lineSlitList[0]),
                    lineSlitList[1], lineSlitList[2], lineSlitList[3], lineSlitList[4], lineSlitList[5],
                    lineSlitList[6], lineSlitList[7], lineSlitList[8]));
        }
        return customerListFromReadCSV;
    }
}
