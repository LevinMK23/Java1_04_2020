package lesson1;

public class DataTypes {

    public static void main(String[] args) {
        // DataTypes dt = new DataTypes(); // linked type
        // int a = 3; // primitive
        // byte, short, int, long, float, double, char, boolean, (void)
        byte byteValue = 3; // 8 bit [-2 ** 7; 2 ** 7) [-128; 127]
        short shortValue = 32000; // 16 bit [-2 ** 15; 2 ** 15)
        int intValue = 2; // 32 bit 10 ** 9
        long longValue = 1111111111111111L; // 64 bit 10 ** 19
        int a = 7;
        float b = 2.2f; // 32 bit 8 знаков
        double doubleValue = 15.3557; // 64 bit 16 знаков
        double x = 1, y = 3;
        System.out.println(x / y);
        // int, double;
        char sym = 'a';
        System.out.println((char)(sym + 1));
        String s = "aassfjfjfj";
        boolean flag = true; // false нельзя 0 1

        //taskThree();
        //taskFour();
        //taskFive();
        //taskSix();
        //taskSeven();
        //taskEight();
    }

    /**
     * 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static int taskThree(int a, int b, int c, int d) {
        System.out.println("\nTask 3.\n");
        return a * (b + (c / d));
    }

    /**
     * 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean taskFour(int a, int b) {
        System.out.println("\nTask 4.\n");
        int sum = a + b;
        if (sum > 10 && sum < 20) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
     *
     * @param a
     */
    public static void taskFive(int a) {
        System.out.println("\nTask 5.\n");
        if (a >= 0) {
            System.out.println("Положительное значение = " + a);
        } else {
            System.out.println("Отрицательно значение = " + a);
        }
    }

    /**
     * 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
     *
     * @param a
     * @return
     */
    public static boolean taskSix(int a) {
        System.out.println("\nTask6.\n");
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     *
     * @param userName
     */
    public static void taskSeven(String userName) {
        System.out.println("\nTask7.\n");
        if (!userName.isEmpty()) {
            System.out.println("Привет, " + userName + "!");
        } else {
            System.out.println("Введите имя!");
        }
    }

    /**
     * 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static void taskEight(int year) {
        System.out.println("\nTask8.\n");
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            System.out.println("Год " + year + " не является високосным");
        } else {
            System.out.println("Год " + year + " является високосным");
        }
    }

}
