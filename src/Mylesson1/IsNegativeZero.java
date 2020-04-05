package Mylesson1;

import java.util.Scanner;

//задание 5
public class IsNegativeZero {
    public static boolean CheckPositive(int number){
        return number>=0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean result = CheckPositive(number);
        System.out.println(result);
    }
}
