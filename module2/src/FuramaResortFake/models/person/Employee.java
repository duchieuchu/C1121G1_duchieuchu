package FuramaResortFake.models.person;

public class Employee extends Person{
    private String educationLevel;
    private String position;
    private double salary;

    public Employee(int id, String name, String dayOfBirth, String gender, String identityCard, String numberPhone, String email, String educationLevel, String position, double salary) {
        super(id, name, dayOfBirth, gender, identityCard, numberPhone, email);
        this.educationLevel = educationLevel;
        this.position = position;
        this.salary = salary;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dayOfBirth='" + getDayOfBirth() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", identityCard='" + getIdentityCard() + '\'' +
                ", numberPhone='" + getNumberPhone() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
