package furama.models.person;

public class Person {
    //1/: Mã nhân viên, Họ tên, Ngày sinh, Giới tính, Số CMND,
    // Số Điện Thoại, Email,
    // Trình độ, Vị trí, lương

    //2/Mã khách hàng, Họ tên , Ngày sinh, Giới tính, Số CMND,
    // Số Điện Thoại, Email,
    // Loại khách, Địa chỉ
    private int id;
    private String name;
    private String dayOfBirth;
    private String gender;
    private int identityCard;
    private int numberPhone;
    private String email;

    public Person() {
    }

    public Person(int id, String name, String dayOfBirth, String gender,
                  int identityCard, int numberPhone, String email) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.identityCard = identityCard;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(int identityCard) {
        this.identityCard = identityCard;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", identityCard=" + identityCard +
                ", numberPhone=" + numberPhone +
                ", email='" + email + '\'' +
                '}';
    }
}
