package lesson5.homework;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Класс содержит данные о сотрудниках
 */
public class Person {
    private String fullName;        // ФИО
    private String position;        // Должность
    private String email;           // Электронная почта
    private long phoneNumber;       // Телефон
    private int salary;             // Зарплата
    private Calendar dateOfBirth;   // Дата рождения

    @Override
    public String toString() {
        return "Данные сотрудника: " +
                "ФИО: " + fullName +
                ", должность: " + position +
                ", email: " + email +
                ", телефон:" + phoneNumber +
                ", зарплата: " + salary +
                ", возраст: " + getAge();
    }

    /**
     *
     * @return возраст сотрудника
     */
    public int getAge() {
        Calendar now = new GregorianCalendar();
        int age = now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        if(now.get(Calendar.DAY_OF_YEAR) < dateOfBirth.get(Calendar.DAY_OF_YEAR)) { age--; }
        return age;
    }

    /**
     * Запрос из командной строки одного параметра типа String
     * @param message подсказка для ввода данных пользователем
     * @return строка, введённая пользователем в консоли
     */
    private String readString(String message) {
        String data;
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println(message);
            try {
                data = in.nextLine();
            } catch (Exception e) {
                System.err.println("Введены некорректные данные");
                continue;
            }
            return data;
        }
    }

    /**
     * Запрос из командной строки одного параметра типа long
     * @param message подсказка для ввода данных пользователем
     * @return чтсло, введённое пользователем в консоли
     */
    private long readLong(String message) {
        long data;
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println(message);
            try {
                data = in.nextLong();
            } catch (Exception e) {
                System.err.println("Введены некорректные данные");
                continue;
            }
            return data;
        }
    }

    /**
     * Запрос из командной строки одного параметра типа int
     * @param message подсказка для ввода данных пользователем
     * @return чтсло, введённое пользователем в консоли
     */
    private int readInt(String message){
        int data;
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println(message);
            try {
                data = in.nextInt();
            } catch (Exception e) {
                System.err.println("Введены некорректные данные");
                continue;
            }
            return data;
        }
    }

    /**
     * Конструктор с параметрами - непосредственное присваивание значений полям через аргументы функции
     * без проверки на валидность
     * @param fullName ФИО
     * @param position должность
     * @param email электронная почта
     * @param phoneNumber телефон
     * @param salary зарплата
     * @param dayOfBirth дата рождения: день
     * @param monthOfBirth дата рождения: месяц
     * @param yearOfBirth дата рождения: год
     */
    public Person(String fullName, String position, String email,
                  long phoneNumber, int salary, int dayOfBirth,
                  int monthOfBirth, int yearOfBirth){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.dateOfBirth = new GregorianCalendar(yearOfBirth, monthOfBirth - 1, dayOfBirth);
    }

    /**
     * Конструктор по умолчанию: ввод параметров из консоли в ходе работы конструктора. Имеет проверки на валидность
     */
    public Person() {
        System.out.println("Занесение нового сотрудника в базу. Введите данные");
        this.fullName = readString("ФИО:");
        this.position = readString("Должность:");
        this.email = readString("Электронный адрес:");
        this.phoneNumber = readLong("Телефон:");
        this.salary = readInt("Зарплата:");
        this.dateOfBirth = new GregorianCalendar();
        dateOfBirth.setLenient(false);
        int year;
        int month;
        int day;
        while(true) {
            try {
                day = readInt("Дата рождения - день:");
                month = readInt("Дата рождения - месяц:") - 1;
                year = readInt("Дата рождения - год:");
                this.dateOfBirth.set(Calendar.YEAR, year);
                this.dateOfBirth.set(Calendar.MONTH, month);
                this.dateOfBirth.set(Calendar.DAY_OF_MONTH, day);
                this.dateOfBirth.getTime();
            } catch(Exception e) {
                System.err.println("Введены некорректные данные");
                continue;
            }
            break;
        }
    }
}
