package homework1;

public class Tasks {
    static void task2 () {
        byte byteVar = 1;
        short shortVar = 2;
        int intVar = 3;
        long longVar = 4L;
        float floatVar = 5;
        double doubleVar = 6;
        char charVar = 'a';
        boolean booleanVar = true;

        System.out.println("byteVar = " + byteVar);
        System.out.println("shortVar = " + shortVar);
        System.out.println("intVar = " + intVar);
        System.out.println("longVar = " + longVar);
        System.out.println("floatVar = " + floatVar);
        System.out.println("doubleVar = " + doubleVar);
        System.out.println("charVar = " + charVar);
        System.out.println("booleanVar = " + booleanVar);
    }

    static int task3(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    static boolean task4(int a, int b) {

        return a + b >= 10 && a + b <= 20;
    }

    static void task5(int a) {
        if (a < 0 ) {
            System.out.printf("Task5: number %d is NEGATIVE\n\n", a);
        } else {
            System.out.printf("Task5: number %d is POSITIVE\n\n", a);
        }
    }

    static boolean task6(int a) {
        return a < 0;
    }

    static void task7(String str) {
        System.out.printf("Task7: Hello, %s!\n\n", str);
    }

    static void task8(int year) {
        if ((year % 400 == 0) | (year % 4 == 0 && !(year % 100 == 0))) {
            System.out.printf("Task8: The year %d is a leap year\n", year);
        } else {
            System.out.printf("Task8: The year %d is not a leap year\n", year);
        }
    }

    public static void main(String[] args) {
        System.out.println("Task2:");
        task2();

        int a = 2, b = 3, c = 4, d = 2;
        int task3Result = task3(1,3,4,2);
        System.out.printf("\nTask3: %d * (%d + (%d / %d)) = %d\n\n", a, b, c, d, task3Result);

        boolean task4Result = task4(a, b);
        if (task4Result) {
            System.out.printf("Task4: sum of %d and %d is in interval 10..20\n\n", a, b);
        } else {
            System.out.printf("Task4: sum of %d and %d is not in interval 10..20\n\n", a, b);
        }

        task5(a);

        boolean task6Result = task6(a);
        System.out.printf("Task6: check if the num %d is negative = %b\n\n", a, task6Result);

        task7("USERNAME");

        task8(1604);
    }
}
