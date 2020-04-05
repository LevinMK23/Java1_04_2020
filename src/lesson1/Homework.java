package lesson1;

import java.util.GregorianCalendar;

public class Homework {

    static double task3 (double a, double b, double c, double d) {
        return a*(b+(c/d));
    }

    static boolean task4 (int a, int b) {
        int c = a+b;
        if (c >= 10 && c <= 20){
            return true;
        }
        return false;
    }

    static void task5 (int a) {
        if (a >= 0) {
            System.out.println("Вы предали методу число: " + a + "\nОно положительное.");
        }else {
            System.out.println("Вы предали методу число: " + a + "\nОно отрицательное.");
        }
    }

    static boolean task6 (int a) {
        if (a < 0){
            return true;
        }
        return false;
    }

    static void task7 (String a){
        System.out.println("Привет, " + a + "!");
    }

    static void task8_1 (int year) { //Первый вариант решения
        if (((year % 4 == 0) & (year % 100 != 0)) || (year % 400) == 0) {
            System.out.println("Введенный год: " + year + ". Является високосным");
        } else {
            System.out.println("Введенный год: " + year + ". Не является високосным");
        }
    }

    static void task8_2(int year){ //Второй вариант решения
        GregorianCalendar Calendar = new GregorianCalendar();
        if(Calendar.isLeapYear(year)) {
            System.out.println("Введенный год: " + year + ". Является високосным");
        } else {
            System.out.println("Введенный год: " + year + ". Не является високосным");
        }
    }

    public static void main(String[] args) {

        System.out.println(task3(1, 2, 3, 4));
        System.out.println(task4(10, 18));
        task5(10);
        System.out.println(task6(-10));
        task7("Михаил");
        task8_1(2020);
        task8_2(2020);

    }
}
