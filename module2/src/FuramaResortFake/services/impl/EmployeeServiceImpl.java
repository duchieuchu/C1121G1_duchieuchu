package FuramaResortFake.services.impl;

import FuramaResortFake.models.person.Employee;
import FuramaResortFake.services.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
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
        System.out.print("enter educationLevel: ");
        String educationLevel = scanner.nextLine();
        System.out.print("enter position: ");
        String position = scanner.nextLine();
        System.out.print("enter salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        Employee newEmployee = new Employee(id, name, dayOfBirth, gender, identityCard, numberPhone,
                email, educationLevel, position, salary);
        employeeList.add(newEmployee);
        System.out.println("COMPLETED!");
    }

    @Override
    public void edit() {

    }
}
