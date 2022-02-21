package FuramaResortFake.services.impl;

import FuramaResortFake.models.person.Customer;
import FuramaResortFake.services.ICustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private static List<Customer> customerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void add() {
        System.out.print("enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("enter name: ");
        String name = scanner.nextLine();
        System.out.print("enter dayOfBirth: ");
        String dayOfBirth = scanner.nextLine();
        System.out.print("enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("enter identityCard: ");
        String identityCard = scanner.nextLine();
        System.out.print("enter numberPhone: ");
        String numberPhone = scanner.nextLine();
        System.out.print("enter Email: ");
        String email = scanner.nextLine();
        System.out.print("enter typeOfCustomer: ");
        String typeOfCustomer = scanner.nextLine();
        System.out.print("enter address: ");
        String address = scanner.nextLine();
        Customer newCustomer = new Customer(id, name, dayOfBirth, gender, identityCard, numberPhone, email,
                typeOfCustomer, address);
        customerList.add(newCustomer);
        System.out.println("COMPLETED!");

    }

    @Override
    public void edit() {

    }
}
