package FuramaResort.services;

import FuramaResort.models.booking.Booking;

import java.util.List;

public class ContractServiceImpl implements IContractService {
    public final String CONTRACT_PATH = "src/FuramaResort/data/contract.csv";
    BookingServiceImpl bookingService = new BookingServiceImpl();

    @Override
    public void add() {
        bookingService.readCSVFileToBookingList(bookingService.BOOKING_PATH);
        List<Booking> bookings=bookingService.bookingList;

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
