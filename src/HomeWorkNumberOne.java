public class HomeWorkNumberOne {
    /*
        Филиппов Вячеслав
        Домашнее задание от 03.04.2020
        Почта для связи: negativ337@mail.ru
        JDK 14
     */
    public static void main(String[] args) {
        double Method3 = Method3(1, 0, 7, 3);

        boolean Method4 = Method4(10, 10);

        String Method5 = Method5(0);

        boolean Method6 = Method6(-22);

        String Method7 = Method7("Михаил");

        String Method8 = Method8(1800); //Високосные года: 1852 1968 2000 2020 1600.
    }

    static double Method3(double a, double b, double c, double d) {
        double e = a * (b + (c / d));
        System.out.printf("Задание №3 " + "%.2f", e);
        return e;
    }

    static boolean Method4(int a, int b) {
        boolean flag = false;
        if ((10 <= a + b) && (a + b <= 20)) {
            flag = true;
        }
        System.out.println("\nЗадание №4 " + flag);
        return flag;
    }

    static String Method5(int a) {
        String value = "Число отрицательное.";
        if (a >= 0) {
            value = "Число положительное.";
        }
        System.out.println("Задание №5 " + value);
        return value;
    }

    static boolean Method6(int a) {
        boolean flag = false;
        if (a < 0) {
            flag = true;
        }
        System.out.println("Задание №6 " + flag);
        return flag;
    }

    static String Method7(String value) {
        String name = "Приветствую " + value + "!";
        System.out.println("Задание №7 " + name);
        return name;
    }

    static String Method8(int year) {
        String value;
        if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
                 value = "високосный.";
        } else value = "не високосный.";
        System.out.println("Задание №8 Год " + year + " " + value);
        return value;
    }
}
