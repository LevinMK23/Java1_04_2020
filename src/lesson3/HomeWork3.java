package lesson3;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

public class HomeWork3 {

    public static void main(String[] args) {
        gameAction();
    }


    private static void gameAction() {
        Scanner userIn = new Scanner(System.in);
            System.out.println("Игра \"Угадай число\"");
                System.out.println("Введи максимальное загадываемое число: ");
                int maxNumberGuessed = userIn.nextInt();
                System.out.println("А теперь количество попыток: ");
                int amountAttempt = userIn.nextInt();
                guessTheNumber(amountAttempt, maxNumberGuessed);
    }

    private static void guessTheNumber (int amountAttempt, int maxNumberGuessed) {
        int guessedNumber = (int) (Math.random() * maxNumberGuessed);
        Scanner in = new Scanner(System.in);
        System.out.printf("Загадывается целое число от 0 до %d. Количество попыток: %d. Введи число: ", maxNumberGuessed, amountAttempt);
        while (amountAttempt >= 1) {
            amountAttempt--;
            int getUserNumber = in.nextInt();
            if (getUserNumber == guessedNumber) {
                System.out.printf("Верно! Ты победил! Осталось попыток: %d. Хочешь сыграть ещё? Введи y, если да (ввод чувствителен к регистру!): ", amountAttempt);
                if (in.hasNext("y")) gameAction();
                else {
                    System.out.println("Ну как хочешь.");
                    return;
                }
            }   else if (amountAttempt == 0) break;
            else if (getUserNumber > guessedNumber) {
                System.out.printf("Неверно. У тебя осталось %d попыток, загаданное число МЕНЬШЕ, попробуй ещё: ", amountAttempt);
            }   else {
                System.out.printf("Неверно. У тебя осталось %d попыток, загаданное число БОЛЬШЕ, попробуй ещё: ", amountAttempt);
            }
        }
        System.out.println("\nНеверно! У тебя закончились попытки, ты проиграл. Хочешь сыграть ещё? Введи y, если да (ввод чувствителен к регистру!): ");
        if (in.hasNext("y")) {
            gameAction();
        }
    }
}
