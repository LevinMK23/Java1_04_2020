package lesson1;

public class Homework {
    public static void main(String[] args) {
        System.out.println(task3(2, 1, 5, 7));
        System.out.println(task4(5, 15));
        task5(5);
        System.out.println(task6(-2));
        task7("Даша");
        task8(20100);
    }

    public static float task3(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean task4(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void task5(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean task6(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void task7(String name) {
        System.out.println("Привет, " + name);
    }
    public static void task8(int a) {
        int b = 4;
        int c = 100;
        int d = 400;
        if (a % c == 0 && a % d != 0) {
            System.out.println("Год невисокосный");
        } else {
            if (a % b == 0) {
                System.out.println("Год високосный");
            }
            else {
                System.out.println("Год невисокосный");
            }

        }
    }
}
