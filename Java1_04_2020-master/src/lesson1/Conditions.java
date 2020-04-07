package lesson1;

public class Conditions {
    public static void main(String[] args) {
        int a = 2;
        // условие - это выражение типа boolean
        boolean condition = a > 3;
        // <, <=, >, >=, ==, !=
        // составные условия
        // ^, ||(или), &&(и), !(не) (краткие)
        boolean f1 = true, f2 = false;
        if (!f1 ^ f2) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        // |, &(полные)
        int b = 4;
        a = 25;
        if (a < 17 && b++ > 3) {

        }
        System.out.println("b = " + b);
        condition = !f1 ^ f2;
        // XOR истина тогда когда аргументы различны
        // ^ -> !==
        System.out.println(condition);
        if (condition) {
            System.out.println("Bigger");
        } else {
            System.out.println("Lesser");
        }
    }
}
