package ru.geekbrains.lesson1_dz;

public class Main {

    static int task3(int a, int b, int c, int d) {
        return a * (b + (c/d));
    }

    static boolean task4(int a, int b) {
        boolean flag;
        if ((a + b) >= 10 && (a + b) <= 20) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    static String task5(int a) {
        String result;
        if (a >= 0) {
            result = "Положительное число";
        } else {
            result = "Отрицательное число";
        }
        return result;
    }

    static boolean task6(int a) {
        boolean flag;
        if (a < 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    static void task7(String name) {
        System.out.println("Привет, " + name + "!");
    }


    public static void main(String[] args) {
        System.out.println("task3 = " + task3(3, 4, 8, 2));
        System.out.println("task4 = " + task4(5,7));
        System.out.println("task5 = " + task5(8));
        System.out.println("task6 = " + task6(-3));
        task7("Михаил");
    }
}
