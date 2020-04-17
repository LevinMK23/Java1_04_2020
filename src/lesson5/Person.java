package lesson5;

public class Person {

    private String name, position, email, tel;
    private double salary;
    private int age;

    public Person(String name, String position, String email, String tel, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", salary=" + String.format("%.2f", salary) +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

}
