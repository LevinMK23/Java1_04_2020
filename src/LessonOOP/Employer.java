package LessonOOP;


public class Employer {
    private String name;
    private String work;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employer(String name, String work, String email, String phone, int salary, int age){
        this.name = name;
        this.work = work;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", work='" + work + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }
}
