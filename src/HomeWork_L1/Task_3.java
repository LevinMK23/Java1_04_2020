package HomeWork_L1;

import java.util.Scanner;

public class Task_3 {

    static int getTask_3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число a = ");
        int a = scanner.nextInt();
        System.out.println("Введите число b = ");
        int b = scanner.nextInt();
        System.out.println("Введите число c = ");
        int c = scanner.nextInt();
        System.out.println("Введите число d = ");
        int d = scanner.nextInt();
        System.out.println(a*(b+(c/d)));
        return 0;
    }

    public static void main(String[] args) {


        System.out.println(getTask_3());




    }
}
