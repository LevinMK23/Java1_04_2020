package lesson5;

public class HW5 {

    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Борис", "Директор", "borissuperstar@email.ru", "+7 495-111-11-11", 1000000, 50);
        persons[1] = new Person("Федор", "Заместитель директора", "fedorzam@email.ru", "+7 495-111-11-12", 700000, 55);
        persons[2] = new Person("Петр", "Помощник директора", "petrhelp@email.ru", "+7 495-111-11-13", 100000, 35);
        persons[3] = new Person("Жанна", "Секретарь", "jannarun@email.ru", "+7 495-111-11-11", 50000, 23);
        persons[4] = new Person("Василий", "Рабочий", " vasyaworkmore@email.ru", "-", 25700.33, 43);

        for (Person person : persons) {
            if (person.getAge() > 40) {
                System.out.println(person);
            }
        }
    }
}
