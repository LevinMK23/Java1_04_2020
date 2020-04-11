package lesson3hw;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    static void guessNumber() {
        int answer;
        Scanner scanner = new Scanner(System.in);
        do {
            Random rand = new Random();
            int guessNumber = rand.nextInt(1001);
            for (int i = 0; i < 10; i++) {
                System.out.println("Попытка: " + (i + 1));
                System.out.println("Угадайте загаданное число: ");
                int inNumber = scanner.nextInt();
                if (guessNumber == inNumber) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (guessNumber < inNumber) {
                    System.out.println("Загаданное число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
            }
            System.out.println("Повторить игру еще раз? [1 – да / 0 – нет]");
            answer = scanner.nextInt();
        } while (answer != 0);
        scanner.close();
    }

    public static void main(String[] args) {
        guessNumber();
    }
}
