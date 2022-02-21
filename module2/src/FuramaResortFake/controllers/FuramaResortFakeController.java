package FuramaResortFake.controllers;

import FuramaResortFake.services.impl.*;

import java.util.Scanner;

public class FuramaResortFakeController {

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean check = true;
        while (check) {
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                case 6:
                    check = false;
                    break;
            }
        }
    }

    public static void displayEmployeeMenu() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void displayCustomerMenu() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void displayFacilityMenu() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    addNewFacility();
                    break;
                case 3:
                    facilityService.displayListFacilityMaintenance();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }
    public static void addNewFacility(){
        FacilityServiceImpl facilityService= new FacilityServiceImpl();
        boolean check =true;
        while (check){
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n");
            Scanner scanner= new Scanner(System.in);
            switch (scanner.nextInt()){
                case 1:
                    facilityService.addVilla();
                    displayFacilityMenu();
                    break;
                case 2:
                    facilityService.addHouse();
                    displayFacilityMenu();
                    break;
                case 3:
                    facilityService.addRoom();
                    displayFacilityMenu();
                    break;
                case 4:
                    displayMainMenu();
                    break;

            }
        }
    }

    public static void displayBookingMenu() {
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new constracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    bookingService.add();
                    break;
                case 2:
                    bookingService.display();
                    break;
                case 3:
                    contractService.add();
                    break;
                case 4:
                    contractService.display();
                    break;
                case 5:
                    contractService.edit();
                    break;
                case 6:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void displayPromotionMenu() {
        PromotionServiceImpl promotionService = new PromotionServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    promotionService.displayListCustomersUseService();
                    break;
                case 2:
                    promotionService.displayListCustomersGetVoucher();
                    break;
                case 3:
                    displayMainMenu();
                    break;
            }
        }
    }
}
