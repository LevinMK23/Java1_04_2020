package lesson1;

public class HomeWorkLesson1 {

    public static void main(String[] args) {
        System.out.println(task3(1,2,3,4));
        System.out.println(task4(5,6));
        task5(5);
        System.out.println(task6(6));
        System.out.println("Василий");
        task8(2020);
    }

    public static float task3(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    public static boolean task4(int a, int b){
        return a+b >= 10 && a+b <= 20;
    }

    public static void task5(int a){
        if (a >= 0)
            System.out.println("Положительное");
        else
            System.out.println("Отрицательное");
    }

    public static boolean task6(int a){
        return a < 0;
    }

    public static void task7(String name){
        System.out.println("Привет, " + name + "!");
    }

    public static void task8(int year){
        boolean any = (year%4 == 0) && !(year%100 == 0);
        if (year%400 == 0)
            any = true;
        System.out.println(any ? "Високосный" : "Невисокосный");
    }
}
