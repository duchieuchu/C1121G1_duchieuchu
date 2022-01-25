package furama.models.person;

public class Employee extends Person {
    //Trình độ, Vị trí, lương
    private String educationLevel;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, String dayOfBirth, String gender, int identityCard,
                    int numberPhone, String email, String educationLevel, String position, int salary) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dayOfBirth='" + getDayOfBirth() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", identityCard=" + getIdentityCard() +
                ", numberPhone=" + getNumberPhone() +
                ", email='" + getEmail() + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
