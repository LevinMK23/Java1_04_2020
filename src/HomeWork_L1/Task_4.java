package HomeWork_L1;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите число а = ");
        int a = scanner.nextInt();
        System.out.println("Ведите число b = ");
        int b = scanner.nextInt();
        int c = a+b;

        if (c>=10){
            if (c <= 20){
                System.out.println("True");
            } else System.out.println("False");
        }else System.out.println("False");
    }
}
