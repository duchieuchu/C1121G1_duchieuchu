package FuramaResort.services;

import FuramaResort.models.booking.Booking;
import FuramaResort.models.facility.Facility;
import FuramaResort.models.person.Customer;
import FuramaResort.utils.WriteFileAndReadFile;

import java.util.List;
import java.util.Scanner;

public class BookingServiceImpl implements IBookingService {
    public final String BOOKING_PATH = "src/FuramaResort/data/booking.csv";
    List<Booking> bookingList;

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.display();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.display();
        System.out.print("enter idBooking: ");
        int idBooking = Integer.parseInt(scanner.nextLine());
        System.out.print("enter startDay: ");
        String startDay = scanner.nextLine();
        System.out.print("enter endDay: ");
        String endDay = scanner.nextLine();

        System.out.print("enter id customer: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = null;

        for (Customer customer1 : customerService.customerList
        ) {
            if (id == customer1.getId()) {
                customer = customer1;
                break;
            }
        }

        System.out.print("enter id facility: ");
        String idFacility = scanner.nextLine();
        Facility facility = null;
        List<Facility>facilityList= facilityService.facilityList;
        for (Facility facility1 : facilityService.facilityList
        ) {
            if (idFacility.equals(facility1.getIdFacility())) {
                facility = facility1;
                break;
            }
        }
        System.out.print("enter typeOfServices: ");
        String typeOfServices = scanner.nextLine();
        Booking newBooking = new Booking(idBooking,startDay,endDay,customer,facility,typeOfServices);

        WriteFileAndReadFile.writeBookingCSVFile(BOOKING_PATH,newBooking);
    }

    @Override
    public void display() {

    }

    @Override
    public void returnMainMenu() {

    }

    @Override
    public void edit() {

    }
}
