package lesson3;
import java.util.Scanner;


public class Task3_1 {

    public static void main(String[] args) {
    gameStart();
    }


    private static void gameStart() {
        Scanner userIn = new Scanner(System.in);
            System.out.println("Игра \"Угадай число\"");
                System.out.println("Введи максимальное число: ");
                int maxNumberGuessed = userIn.nextInt();
                System.out.println("А теперь количество попыток: ");
                int amountAttempt = userIn.nextInt();
                guessTheNumber(amountAttempt, maxNumberGuessed);
    }

    private static void guessTheNumber (int tryCount, int maxNumberGuessed) {
        int guessedNumber = (int) (Math.random() * maxNumberGuessed);
        Scanner in = new Scanner(System.in);
        System.out.printf("Загадывается целое число от 0 до %d. Количество попыток: %d. Введи число: ", maxNumberGuessed, tryCount);
        while (tryCount > 0) {
            tryCount--;
            int getUserNumber = in.nextInt();
            if (getUserNumber == guessedNumber) {
                System.out.printf("Верно! Ты победил! Осталось попыток: %d. Хочешь сыграть ещё? Введи 1, если да: ", tryCount);
                if (in.hasNextInt(1)) gameStart();
                else {
                    System.out.println("Ну как хочешь.");
                    return;
                }
            } else if (tryCount == 0) {
                break;

            } else if (getUserNumber > guessedNumber) {
                System.out.printf("Неверно. У тебя осталось %d попыток, загаданное число МЕНЬШЕ, попробуй ещё: ", tryCount);
            } else {
                System.out.printf("Неверно. У тебя осталось %d попыток, загаданное число БОЛЬШЕ, попробуй ещё: ", tryCount);
            }
        }
        System.out.println("\nНеверно! У тебя закончились попытки, ты проиграл. Хочешь сыграть ещё? Введи 1, если да: ");
        if (in.hasNextInt(1)) {
            gameStart();
        }
    }
}
