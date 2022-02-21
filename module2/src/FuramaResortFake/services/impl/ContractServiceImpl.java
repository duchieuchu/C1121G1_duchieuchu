package FuramaResortFake.services.impl;

import FuramaResortFake.models.booking.Booking;
import FuramaResortFake.models.contract.Contract;
import FuramaResortFake.models.person.Customer;
import FuramaResortFake.services.IContractService;

import java.util.*;

public class ContractServiceImpl implements IContractService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Contract contract : contractList){
            System.out.println(contract.toString());
        }

    }

    @Override
    public void add() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for (Booking booking:bookingSet){
            bookingQueue.add(booking);
        }
        Booking booking = bookingQueue.poll();
        Customer customer = booking.getCustomer();

        System.out.println("dang tao hop hop dong cho Booking co thong tin: "+booking.toString());
        System.out.println("dang tao hop hop dong cho khach hang co thong tin: "+customer.toString());
        System.out.println("enter idContract");
        int idContract= Integer.parseInt(scanner.nextLine());
        System.out.println("enter deposit");
        double deposit= Double.parseDouble(scanner.nextLine());
        System.out.println("enter totalPay");
        double totalPay=Double.parseDouble(scanner.nextLine());


//        Contract contract = new Contract(idContract,booking,deposit,totalPay);
//        contractList.add(contract);
//        System.out.println("COMPLETED!");


    }

    @Override
    public void edit() {

    }
}
