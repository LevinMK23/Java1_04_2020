package Mylesson1;

import java.util.Scanner;

//Задание 6
public class IsNegative {
    public static boolean CheckNegative(int number){
        return number<0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean result = CheckNegative(number);
        System.out.println(result);
    }
}
