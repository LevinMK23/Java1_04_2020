
public class Main {

    public static void main(String[] args) {

        System.out.println("Task 3");
        System.out.println(task3(1.2f, 2.3f, 3.5f, 4f));
        System.out.println(task3(2.2f, 4.3f, 6.5f, 2f));

        System.out.println("Task 4");
        System.out.println(task4(10, 5));
        System.out.println(task4(2, 3));

        System.out.println("Task 5");
        task5(20);
        task5(-30);

        System.out.println("Task 6");
        System.out.println(task6(200));
        System.out.println(task6(-200));

        System.out.println("Task 7");
        task7("Вика");
        task7("Ваня");

        System.out.println("Task 8");
        task8(1996);
        task8(2005);
        task8(1900);
    }

    private static float task3(float a, float b, float c, float d) {
        float result;
        result = a * (b + (c / d));
        return result;
    }

    private static boolean task4(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void task5(int a) {
        String suffix;
        suffix = " положительное";

        if (task6(a)) {
            suffix = " отрицательное";
        }

        System.out.println("Число " + a + suffix);
    }

    private static boolean task6(int a) {
        return a < 0;
    }

    private static void task7(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void task8(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0
                    && year % 400 != 0) {

                System.out.println("Год не високосный");
            } else {
                System.out.println("Год високосный");
            }
        } else {
            System.out.println("Год не високосный");
        }
    }
}
