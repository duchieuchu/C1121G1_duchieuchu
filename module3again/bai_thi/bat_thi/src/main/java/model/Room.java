package model;

public class Room {
    private Integer id;
    private String userName;
    private String phone;
    private String checkIn;
    private RentalType rentalType;
    private String otherInfo;

    public Room(Integer id, String userName, String phone, String checkIn, RentalType rentalType, String otherInfo) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.checkIn = checkIn;
        this.rentalType = rentalType;
        this.otherInfo = otherInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
