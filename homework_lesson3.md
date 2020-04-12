package geekbrains.lesson1;

import java.util.Scanner;

public class Main {


    private static void playGame (int range) {
        Scanner sc = new Scanner(System.in);
        do {
            int randNumber = (int) (Math.random() * range);
            for (int i = 3; i > 0; i--) {
                System.out.println("Введите число от 0 до " + range);
                int input = sc.nextInt();
                if (input == randNumber) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (input > randNumber) {
                    System.out.println("Загаданное число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
                System.out.println("Осталось попыток: " + (i - 1));
                if (i == 1) System.out.println("Вы проиграли");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (sc.nextInt() == 1);
    }

    public static void main(String[] args) {

        System.out.println("Ваша задача - угадать число");
        int range = 10;
        playGame(range);
        System.out.println("Спасибо за участие! До свидания!");

    }

}