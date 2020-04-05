package HomeWork_L1;

import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите число = ");
        int a = scanner.nextInt();

        if (a>=0){
            System.out.println("Число положительное");
        }else System.out.println("Число отрицательно");
    }
}
