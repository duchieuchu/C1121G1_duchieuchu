package ss11_dsa_stack_queue.optional.to_chuc_du_lieu_hop_li_demerging_use_queue;

public class Staff {
    //Họ tên, giới tính, ngày tháng năm sinh, ...
    private String name;
    private String gender;
    private String birthDay;

    public Staff() {
    }

    public Staff(String name, String gender, String birthDay) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
