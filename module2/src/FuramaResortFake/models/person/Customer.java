package FuramaResortFake.models.person;

public class Customer extends Person{
    private String typeOfCustomer;
    private String address;


    public Customer(int id, String name, String dayOfBirth, String gender, String identityCard, String numberPhone, String email, String typeOfCustomer, String address) {
        super(id, name, dayOfBirth, gender, identityCard, numberPhone, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dayOfBirth='" + getDayOfBirth() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", identityCard='" + getIdentityCard() + '\'' +
                ", numberPhone='" + getNumberPhone() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
