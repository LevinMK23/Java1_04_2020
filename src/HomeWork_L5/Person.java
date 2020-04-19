package HomeWork_L5;

import java.util.Arrays;
import java.util.Scanner;

public class Person {


    private  String name, email, position, phone;
    private  int salary, age;
    private static Scanner scanner = new Scanner(System.in);
    private static Person[] persArray = new Person[5];


    public Person(String name, String email, String position, String phone, int salary, int age) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void infoPerson() {
        String cnr = scanner.next();
        for (Person person : persArray) {
            if (person.name.equals(cnr)) {
                System.out.println(Arrays.toString(new Person[]{person}));

            }

        }
    }
    public static void infoAge() {
        System.out.println("Люди старше 40 лет:");
        for (Person person : persArray) {
            if (person.age > 40) {
                System.out.println(Arrays.toString(new Person[]{person}));
            }

        }
    }




    public static void main(String[] args) {
        persArray[0] = new Person("Vychislov","ivivan@mailbox.com", "Engineer",  "892312312",20000,30);
        persArray[1] = new Person("ivan", "Gluhenko@mail.ru","Marketer", "8902465891",35000,41);
        persArray[2] = new Person("Alex", "Kozlov@mail.ru","Mechanic", "8902495896",40000,45);
        persArray[3] = new Person("Vladislav", "Horochih@mail.ru","Photographer", "8924466891",20000,25);
        persArray[4] = new Person("Egor", "Durakov@mail.ru","Teacher", "8901465364",35000,70);
        infoPerson();
        infoAge();

    }
}

