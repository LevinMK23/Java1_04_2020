package Mylesson1;

import java.util.Scanner;

public class PlusLimit {
    public static boolean CheckLimit(byte number1, byte number2){
        return (number1 + number2)>=10 && (number1 + number2)<=20;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte number1 = scanner.nextByte();
        byte number2 = scanner.nextByte();
        boolean result = CheckLimit(number1, number2);
        System.out.println(result);
    }
}
