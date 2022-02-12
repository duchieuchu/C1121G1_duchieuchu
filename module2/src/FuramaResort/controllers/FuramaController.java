package FuramaResort.controllers;

import FuramaResort.services.*;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        PromotionServiceImpl promotionService = new PromotionServiceImpl();
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        while (check) {
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            System.out.println("enter your choose: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1\tDisplay list employees\n" +
                            "2\tAdd new employee\n" +
                            "3\tEdit employee\n" +
                            "4\tReturn main menu\n");
                    System.out.println("enter your choice: ");
                    int chooseEmployeeManagement = scanner.nextInt();
                    switch (chooseEmployeeManagement){
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
                            employeeService.returnMainMenu();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.\tDisplay list customers\n" +
                            "2.\tAdd new customer\n" +
                            "3.\tEdit customer\n" +
                            "4.\tReturn main menu\n");
                    System.out.println("enter your choice: ");
                    int chooseCustomerManagement = scanner.nextInt();
                    switch (chooseCustomerManagement) {
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
                            customerService.returnMainMenu();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1\tDisplay list facility\n" +
                            "2\tAdd new facility\n" +
                            "3\tDisplay list facility maintenance\n" +
                            "4\tReturn main menu\n");
                    System.out.println("enter your choice: ");
                    int chooseFacilityManagement = scanner.nextInt();
                    switch (chooseFacilityManagement) {
                        case 1:
                            facilityService.display();
                            break;
                        case 2:
                            facilityService.add();
                            break;
                        case 3:
                            facilityService.displayListFacilityMaintenance();
                            break;
                        case 4:
                            facilityService.returnMainMenu();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new contracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n");
                    System.out.println("enter your choice ");
                    int chooseBookingManagement = scanner.nextInt();
                    switch (chooseBookingManagement) {
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
                            contractService.returnMainMenu();
                            break;
                    }
                    break;
                case 5:
                    System.out.println("1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    System.out.println("enter your choice ");
                    int choosePromotionManagement = scanner.nextInt();
                    switch (choosePromotionManagement) {
                        case 1:
                            promotionService.displayListCustomersUseService();
                            break;
                        case 2:
                            promotionService.displayListCustomersGetVoucher();
                            break;
                        case 3:
                            promotionService.returnMainMenu();
                            break;
                    }
                    break;
                case 6:
                    check = false;
            }
        }
    }
}
