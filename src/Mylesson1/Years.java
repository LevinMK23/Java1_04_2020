package Mylesson1;

import java.util.Scanner;

// Задание 8.
public class Years {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearUpstart = scanner.nextInt();
        if ((yearUpstart % 4 != 0) || (yearUpstart % 100 == 0) && (yearUpstart % 400 != 0)){
            System.out.println("Обычный год!!!");
        } else {
            System.out.println("Выскокосный!!!");
        }
    }
}
