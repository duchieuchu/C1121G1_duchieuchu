package FuramaResortFake.models.booking;

import FuramaResortFake.models.facility.Facility;
import FuramaResortFake.models.person.Customer;

public class Booking {
    //private int idBooking;
    //private String startDay;
    //private String endDay;
    //private Customer customer;
    //private Facility facility;
    //private String typeOfServices;
    private int idBooking;
    private String startDate;
    private String endDate;
    private Customer customer;
    private Facility facility;
    private String typeOfServices;

    public Booking(int idBooking, String startDate, String endDate, Customer customer, Facility facility, String typeOfServices) {
        this.idBooking = idBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facility = facility;
        this.typeOfServices = typeOfServices;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getTypeOfServices() {
        return typeOfServices;
    }

    public void setTypeOfServices(String typeOfServices) {
        this.typeOfServices = typeOfServices;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customer=" + customer +
                ", facility=" + facility +
                ", typeOfServices='" + typeOfServices + '\'' +
                '}';
    }
}
