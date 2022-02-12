package FuramaResort.services;

import FuramaResort.models.facility.Facility;

import java.util.Scanner;

public class BookingServiceImpl implements IBookingService {
    public final String BOOKING_PATH="src/FuramaResort/data/booking.csv";

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        FacilityServiceImpl facilityService= new FacilityServiceImpl();
        facilityService.display();
        CustomerServiceImpl customerService= new CustomerServiceImpl();
        System.out.println("enter idBooking");
        System.out.println("enter startDay");
        System.out.println("enter endDay");
        System.out.println("enter customer");
        System.out.println("enter facility");
        System.out.println("enter typeOfServices");

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
