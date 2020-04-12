package lesson3;

import java.util.Scanner;


public class Task3_1 {

    public static void main(String[] args) {
        gameStart(true);
    }


    private static void gameStart(boolean choice) {
        if (choice) {
            Scanner userIn = new Scanner(System.in);
            System.out.println("Игра \"Угадай число\"");
            System.out.println("Введи максимальное число: ");
            int maxNumberGuessed = userIn.nextInt();
            System.out.println("А теперь количество попыток: ");
            int amountAttempt = userIn.nextInt();
            guessTheNumber(amountAttempt, maxNumberGuessed);
        } else {
            System.out.println("Ну как хочешь :)");
            System.exit(0);
        }
    }

    private static void guessTheNumber(int totalTryCount, int maxNumberGuessed) {
        int guessedNumber = (int) (Math.random() * maxNumberGuessed);
        int tryCounter = totalTryCount;
        Scanner in = new Scanner(System.in);
        System.out.printf("Загадывается целое число от 0 до %d. Количество попыток: %d. Игра начинается! Да прибудет с тобой сила. ", maxNumberGuessed, totalTryCount);
        while(tryCounter > 0) {
            tryCounter--;
            System.out.print("Введите число: ");
            int getUserNumber = in.nextInt();
            if (getUserNumber == guessedNumber) {
                System.out.printf("Верно! Ты победил! Осталось попыток: %d из %d. Хочешь сыграть ещё? Введи 1, если да: ", tryCounter, totalTryCount);
                gameStart(in.nextInt() == 1);
            } else if (tryCounter != 0){
                System.out.printf("Неверно. Осталось попыток: %d. Загаданное число %s. ", tryCounter, (getUserNumber > guessedNumber ? "МЕНЬШЕ" : "БОЛЬШЕ"));
            } else {
                System.out.println("Неверно! У тебя закончились попытки, ты проиграл. Хочешь сыграть ещё? Введи 1, если да: ");
                gameStart(in.nextInt() == 1);
            }
        }
    }
}

