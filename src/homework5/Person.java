package homework5;

public class Person {

    private String name;
    private String surname;
    private String patronymic;

    private int age;

    private String position;
    private double salary;

    private String email;
    private String phone;

    public Person() {
    }

    public Person(String name, String surname, String patronymic, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Person(String name, String surname, String patronymic, int age, String position, double salary, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        String personStrTemplate = "Name: %s\n" +
                "Surname: %s\n" +
                "Patronymic: %s\n" +
                "Age: %d\n" +
                "Position: %s\n" +
                "Salary: %f\n" +
                "Phone: %s\n" +
                "E-mail: %s";


        return String.format(personStrTemplate,
                this.name,
                this.surname,
                this.patronymic,
                this.age,
                this.position,
                this.salary,
                this.phone,
                this.email);
    }
}
