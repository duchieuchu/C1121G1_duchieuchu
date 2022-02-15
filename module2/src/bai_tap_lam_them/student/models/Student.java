package bai_tap_lam_them.student.models;

public class Student {
    private String name;
    private String gender;
    private String dayOfBirth;
    private String numberPhone;
    private String address;

    public Student() {
    }

    public Student(String name, String gender, String dayOfBirth, String numberPhone, String address) {
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.numberPhone = numberPhone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", numberPhone=" + numberPhone +
                ", address='" + address + '\'' +
                '}';
    }
    public String writeToSCVFile(){
        return "Student={ name:"+getName()+" ,"+"gender:"+getGender()+" ,"+"dayOfBirth:"+getDayOfBirth()+","
                +"numberPhone:"+getNumberPhone()+" ,"+"address:"+getAddress()+ " }";
    }
}
