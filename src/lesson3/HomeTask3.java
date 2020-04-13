package lesson3;

import java.util.Random;
import java.util.Scanner;


public class HomeTask3 {
    public static void main(String[] args) {
        new HomeTask3().startGame();

    }

    public void startGame() {
        Random randomNumber = new Random();
        int random = randomNumber.nextInt(1000);
        System.out.println("Отгадай число от 0 до 1000");
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            int guess = scanner.nextInt();
            System.out.println("Это твоя " + i + " попытка!" + " Еще осталось: " + (10 - i) + ".");
            if (guess < random)
                if (i < 10)
                    System.out.println("Загаданное число больше указанного");
            if (guess > random)
                if (i < 10)
                    System.out.println("Загаданное число меньше указанного");
            if (guess == random)
                if (i <= 10)
                    win();
            if (i >= 10 && guess != random)
                lose();

        }
        endGame();

    }

    public void endGame() {
        System.out.println();
        System.out.println("Повторить игру еще раз? 1 - да, 0 - нет.");
        Scanner scanner = new Scanner(System.in);
        int end = scanner.nextInt();
        if (end == 1)
            startGame();

    }

    public void win() {
        System.out.println();
        System.out.println("Ты победил!!!");
        endGame();

    }

    public void lose() {
        System.out.println();
        System.out.println("Ты проиграл!");

    }


}
