package FuramaResort.services;

import FuramaResort.models.booking.Booking;
import FuramaResort.models.facility.Facility;
import FuramaResort.models.person.Customer;
import FuramaResort.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingServiceImpl implements IBookingService {

    public final String BOOKING_PATH = "src/FuramaResort/data/booking.csv";
    List<Booking> bookingList= new ArrayList<>();

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

        for (Facility facility1 : facilityService.facilityList
        ) {
            if (idFacility.equals(facility1.getIdFacility())) {
                facility = facility1;
                break;
            }
        }
        System.out.print("enter typeOfServices: ");
        String typeOfServices = scanner.nextLine();
        Booking newBooking = new Booking(idBooking, startDay, endDay, customer, facility, typeOfServices);

        WriteFileAndReadFile.writeBookingCSVFile(BOOKING_PATH, newBooking);
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

    public void readCSVFileToBookingList(String pathLine) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        bookingList=new ArrayList<>();
        List<String> lineList = WriteFileAndReadFile.readFile(pathLine);
        String[] lineSplitList;
        Booking booking= new Booking();

        for (String line : lineList) {
            lineSplitList = line.split(",");
            for (Customer customer : customerService.customerList) {
                if (Integer.parseInt(lineSplitList[3]) == customer.getId()) {
                    booking.setCustomer(customer);
                }
            }
            for (Facility facility:facilityService.facilityList){
                if (lineSplitList[4].equals(facility.getIdFacility())){
                    booking.setFacility(facility);
                }
            }
            booking.setIdBooking(Integer.parseInt(lineSplitList[0]));
            booking.setStartDay(lineSplitList[1]);
            booking.setEndDay(lineSplitList[2]);
            booking.setTypeOfServices(lineSplitList[5]);
            bookingList.add(booking);
        }
    }
}
