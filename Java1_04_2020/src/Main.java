import com.sun.org.apache.xpath.internal.objects.XString;
import com.sun.prism.shader.Texture_ImagePattern_AlphaTest_Loader;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

//В программе совсем нет никаких защиток от дурака, но, они и не требовались, да и займут много времени)

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    //Играюсь с даблами, интересно, что получится.
    static void method1(double a, double b, double c, double d) {
        double result = a * (b + (c / d));
        System.out.println("Результат вычисления по методу 1 - " + result);
    }

    static void method2(double a, double b) {
        double result = a + b;
        if ( result >= 10 && result <= 20 ) {
            System.out.println("Сумма двух чисел находится в передал от 10 до 20 (включительно)");
        } else if (result < 10) {
            System.out.println("Результат суммы двух чисел меньше 10");
        } else {
            System.out.println("Резльутат суммы двух чисел больше 20");
        }
    }

    static void method3(int a) {
        if (a < 0) {
            System.out.println("Введенное число является отрицательным");
        } else {
            System.out.println("Введенное число является положительными");
        }
    }

    //Написал колхозно, через иф, идея предложила сама все исправить. Результатом доволен :D
    static boolean method4(int a) {
        return a < 0;
    }

    static void method5(String a) {
        System.out.println("Привет, " + a + "!");
    }

    static void method6(int a) {
        //Если год делится на 400 без остатка или год делится на 4 без остатка и год не делится на 100 без остатка, значит год - весокосный, иначе - год не весокосный.
        if ((a % 400 == 0) || ((a % 4 == 0) && (a % 100 != 0))) {
            System.out.println("Введенный год " + a + " является весокосным");
        } else {
            System.out.println("Введенный год " + a + " не является весокосным");
        }
    }

    public static void main(String[] args) {
        //Выглядит колхозно, как сделать нормально?)
        System.out.println("Выберите метод, пожалуйста:  Метод 1 - вычисление по формуле a * (b + (c / d))");
        System.out.println("Метод 1 - принимает четыре числа, и прозводит вычисление по формуле a * (b + (c / d))");
        System.out.println("Метод 2 - принимает два числа, и проверяет что их сумма находится в пределах от 10 до 20 (включительно)");
        System.out.println("Метод 3 - принимает целое число, и проверяет, является ли число положительным, или отрицательным. " +
                "Примичание: ноль считаем положительным числом.");
        System.out.println("Метод 4 - принимает целое число, и проверяет, положительное ли число передали, или отрицательное. " +
                "Примичание: ноль считаем положительным числом, если число положительное - метод возвращает false");
        System.out.println("Метод 5 - принимает строку (имя) и выводит приветствие «Привет, указанное_имя!»");
        System.out.println("Метод 6 - принимает целое число (год) и определяет является ли год високосным. " +
                "Примичание: каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");

        int selectedMethod = scanner.nextInt();
        if (selectedMethod == 1) {
            //Тоже колхоз, не знаю, как сделать в цикле(
            System.out.println("Введите число a, пожалуйста:");
            double a = scanner.nextDouble();
            System.out.println("Введите число b, пожалуйста:");
            double b = scanner.nextDouble();
            System.out.println("Введите число c, пожалуйста:");
            double c = scanner.nextDouble();
            System.out.println("Введите число d, пожалуйста:");
            double d = scanner.nextDouble();
            method1(a, b, c, d);
        } else if (selectedMethod == 2) {
            System.out.println("Введите первое число, пожалуйста:");
            double a = scanner.nextDouble();
            System.out.println("Введите второе число, пожалуйста:");
            double b = scanner.nextDouble();
            method2(a,b);
        } else if (selectedMethod == 3) {
            System.out.println("Введите число, пожалуйста:");
            int a = scanner.nextInt();
            method3(a);
        } else if (selectedMethod ==4) {
            System.out.println("Введите число, пожалуйста:");
            int a = scanner.nextInt();
            System.out.println(method4(a));
        } else if (selectedMethod == 5) {
            System.out.println("Введите ваше имя, пожалуйста:");
            String a = scanner.next();
            method5(a);
        } else {
            System.out.println("Введите год, пожалуйста:");
            int a = scanner.nextInt();
            method6(a);
        }
    }
}
