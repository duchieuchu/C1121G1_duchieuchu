package FuramaResort.models.booking;

import FuramaResort.models.facility.Facility;
import FuramaResort.models.person.Customer;

public class Booking {
private int idBooking;
private String startDay;
private String endDay;
private Customer customer;
private Facility facility;
private String typeOfServices;

    public Booking() {
    }

    public Booking(int idBooking, String startDay, String endDay, Customer customer, Facility facility, String typeOfServices) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
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

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
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
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customer=" + customer +
                ", servicesName=" + facility +
                ", typeOfServices='" + typeOfServices + '\'' +
                '}';
    }
    public String getInformationBooking(){
        return idBooking+","+startDay+","+endDay+customer.getId()+","+facility.getServiceName()+typeOfServices;
    }
}
