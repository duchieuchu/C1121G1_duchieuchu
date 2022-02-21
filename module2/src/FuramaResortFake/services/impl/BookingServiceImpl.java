package FuramaResortFake.services.impl;

import FuramaResortFake.models.booking.Booking;
import FuramaResortFake.models.facility.Facility;
import FuramaResortFake.models.facility.Villa;
import FuramaResortFake.models.person.Customer;
import FuramaResortFake.services.IBookingService;
import FuramaResortFake.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer(1, "hieu", "01/01/2000", "nam",
                "123412345", "0333333333", "hieu@gmail.com", "Diamond", "Da Nang"));
        customerList.add(new Customer(2, "chien", "02/02/1995", "nam",
                "123411111", "0322233344", "chien@gmail.com", "Member", "Da Nang"));
        facilityIntegerMap.put(new Villa("SVVL-1001", "villa 1", 200,
                100, 7, "Day", "Vip", 30, 3), 0);
        facilityIntegerMap.put(new Villa("SVVL-1002", "villa 2", 270,
                200, 9, "", "Normal", 30, 3), 0);

    }

    @Override
    public void display() {
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    public Set<Booking> sendBooking() {
        return bookingSet;
    }

    @Override
    public void add() {
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size();
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter id Booking: ");
        int idBooking = Integer.parseInt(scanner.nextLine());
        System.out.print("enter startDate: ");
        String startDate = scanner.nextLine();
        System.out.print("enter endDate: ");
        String endDate = scanner.nextLine();
        System.out.print("enter typeOfServices: ");
        String typeOfServices = scanner.nextLine();

        Booking booking = new Booking(idBooking, startDate, endDate, customer, facility, typeOfServices);
        bookingSet.add(booking);
        System.out.println("COMPLETED!");


        //    private int idBooking;
        //    private String startDate;
        //    private String endDate;
        //    private Customer customer;
        //    private Facility facility;
        //    private String typeOfServices;
    }

    public static Customer chooseCustomer() {
        System.out.println("CustomerList: ");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter id Customer: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());

        while (check) {
            for (Customer customer : customerList) {
                if (customer.getId() == id) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Wrong id!! Enter id Customer again: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("FacilityList: ");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey().toString());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter id Service: ");
        boolean check = true;
        String idService = scanner.nextLine();

        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                if (idService.equals(entry.getKey().getIdService())) {
                    check = false;
                    return entry.getKey();
                }
            }
            if (check) {
                System.out.println("Wrong id!! Enter id Service again: ");
                idService = scanner.nextLine();
            }
        }
        return null;
    }

    @Override
    public void edit() {

    }
}
