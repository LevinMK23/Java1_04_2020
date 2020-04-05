package Mylesson1;

import java.util.Scanner;

public class Сalculate {
    public static double Calc(double a, double b, double c, double d){
        return a*(b+(c/d));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextByte();
        double b = scanner.nextByte();
        double c = scanner.nextByte();
        double d = scanner.nextByte();
        double result = Calc(a, b, c, d);
        System.out.println(result);
    }
}
