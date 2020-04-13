package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheNumber {

    public static void main(String[] args) throws IOException {
        int limit = 1000;
        int attemps = 10;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (; ; ) {
            System.out.println("Угадайте число от 0 до " + limit + "\nУ вас: " + attemps + " попыток");
            int number = (int) (Math.random() * limit);
            int i = 1;
            while (true) {
                int n = Integer.parseInt(reader.readLine());
                if (n > number) {
                    System.out.println("Загаданное число меньше.\nОсталось:" + (attemps - i) + " попыток");
                } else if (n < number) {
                    System.out.println("Загаданное число больше.\nОсталось: " + (attemps - i) + " попыток");
                } else if (n == number) {
                    System.out.println("Вы выиграли!!!");
                    break;
                }
                i++;
                if (i > attemps) {
                    System.out.println("Вы проиграли=((((( Было загадано: " + number);
                    break;
                }
            }
            System.out.println("Сыграть заново - 1. Завершить игру - 0");
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                break;
            } else if (n == 1) {
                System.out.println("Продолжаем!!!");
            } else if (n > 1) {
                System.out.println("Введите 1 или 0");
            }
        }
        System.out.println("Игра завершена");
    }
}