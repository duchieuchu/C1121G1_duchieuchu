package FuramaResort.models.person;

public class Customer extends Person {
    //Loại khách, Địa chỉ
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String dayOfBirth, String gender,
                    String identityCard, String numberPhone, String email, String typeCustomer, String address) {
        super(id, name, dayOfBirth, gender, identityCard, numberPhone, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
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
                ", identityCard=" + getIdentityCard() +
                ", numberPhone=" + getNumberPhone() +
                ", email='" + getEmail() + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public String writeToCSVFile(){
        return getId()+","+getName()+","+getDayOfBirth()+","+getGender()+","+getIdentityCard()+","+getNumberPhone()
                +","+getEmail()+","+typeCustomer+","+address;
    }
}
