package lesson1;

public class HomeWork {
    public static void main(String[] args) {

    }

    //По условию методички аргументы имеют тип float
    public static Float task3(float a, float b,float c, float d) {
        return a * (b + (c / d));
    }


    public static boolean task4(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }


    public static void task5(int a) {
        if (a >= 0) {
            System.out.println("This is a positive number.");
        } else {
            System.out.println("This is a negative number.");
        }
    }


    public static boolean task6 (int a) {
        return a < 0;
    }


    public static void task7 (String name) {
        System.out.println("Привет, " + name + "!");
    }

    /* Високосным годом считается год, который:
    1. Делится на 400 без остатка.
    2. Делится на 4 без остатка, но при этом не кратен 100.
    Можно было оба условия добавить в первый блок if, но так снизится читаемость кода.*/

    public static void task8 (int year) {
        if (year % 400 == 0) {
            System.out.println("It's a leap year");
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println("It's a leap year");
        } else {
            System.out.println("This is not a leap year");
        }
    }
}
