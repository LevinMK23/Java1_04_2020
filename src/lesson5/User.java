package lesson5;

public class User {

    private String firstName;
    private String lastName;
    private String patronymicName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    //print information about co-workers
    @Override
    public String toString() {
        return "User{" +
                "first name='" + firstName + '\'' +
                "patronimic name='" + patronymicName + '\'' +
                "last name='" + lastName + '\'' +
                "position='" + position + '\'' +
                "email='" + email + '\'' +
                "phone='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    //adding getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getPatronymicName() { return patronymicName; }
    public void setPatronymicName(String patronymicName) { this.patronymicName = patronymicName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    //adding constructor
    public User(String firstName, String patronymicName, String lastName, String position, String email, String phoneNumber, int salary, int age) {
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

}
