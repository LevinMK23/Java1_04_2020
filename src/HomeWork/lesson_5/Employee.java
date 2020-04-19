package HomeWork.lesson_5;

import java.util.Random;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;
    private final static Random rnd = new Random();

    public Employee(String name, int age, String position, String email, String phone) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.salary = rnd.nextInt(100000);
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "name=" + name +
                ", position=" + position +
                ", age=" + age +
                ", salary=" + salary +
                ", phone=" + phone +
                ", email=" + email +
                '}';
    }


}
