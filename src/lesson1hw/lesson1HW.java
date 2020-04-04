package lesson1hw;

public class lesson1HW {

    static float task3 (float a, float b, float c, float d) {
        return a * (b + (c/d));
    }

    static boolean task4 (int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static void task5(int a) {
        if (a < 0) {
            System.out.println("Task 5: Negative");
        } else {
            System.out.println("Task 5: Positive");
        }
    }

    static boolean task6 (int a) {
        if (a < 0) {
            return true;
        } return false;
    }

    static void task7 (String username) {
        System.out.println("Task 7: Hello, " + username);
    }

    static void task8 (int year) {
        if ((year % 4 != 0) || (year % 100 == 0 && year % 400 != 0)) {
            System.out.println("Task 8: Usual year");
        } else {
            System.out.println("Task 8: Intercalary year");
        }
    }

    public static void main(String[] args) {
        System.out.println("Task 3: " + task3(10,10,10,10));
        System.out.println("Task 4: " + task4(14, 10));
        task5(-2);
        System.out.println("Task 6: " + task6(-1));
        task7("Ivan");
        task8(1996);

    }

}
