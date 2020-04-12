package lesson3;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class guess_game {
    public static void main(String[] args) {
        lalkaAnswer();
    }

    public static void yesGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите максимальное кол-во попыток: ");
        try {
            int inputTryCount = in.nextInt();
            System.out.println("Введите максимальное число, которое может загадать компьютер");
            int inpetMaxValue = in.nextInt();
            game(inputTryCount, inpetMaxValue);
        } catch (InputMismatchException t) {
            System.out.println("Нужно вводить числа, в формате 1234!");
            yesGame();
        }
    }

    public static void game(int inputTryCount, int inputMaxValue) {
        Scanner in = new Scanner(System.in);
        int answer = (int) (Math.random() * inputMaxValue);
        int tryCount = 1;
        int maxTryCount = inputTryCount;
        System.out.println("Привет! сыграем в угадайку? Введи число от 0 до " + inputMaxValue);
        try {
            int userAnswer = in.nextInt();
            for (int i = 0; i < maxTryCount; i++) {
                if (userAnswer == answer) {
                    System.out.println("Поздравляю! Вы угадали, а правильное число, это: " + answer);
                    System.out.println("Количество попыток: " + tryCount);
                    return;
                } else if (userAnswer > answer) {
                    System.out.println("Ваше число больше, чем загаданное, попробуйте еще раз");
                    System.out.println("Введите число от 0 до " + inputMaxValue);
                    userAnswer = in.nextInt();
                    tryCount++;
                } else if (userAnswer < answer) {
                    System.out.println("Ваше число меньше, чем загаданное, попробуйте еще раз");
                    System.out.println("Введите число от 0 до " + inputMaxValue);
                    userAnswer = in.nextInt();
                    tryCount++;
                }
            }
            System.out.println("Не получилось(((");
        } catch (InputMismatchException t) {
            System.out.println("Нужно вводить ЧИСЛО!");
            maxTryCount--;
            System.out.println("А попыток осталось на одну меньше: " + (maxTryCount - tryCount));
            game(inputTryCount, inputMaxValue);

        }
    }

    public static void tryAgain() {
        try {
            System.out.println("Хочешь сыграть еще раз? Введи \"1\", если хочешь сыграть еще раз, " +
                    "\nили \"2\", если ты оень занятой человек и у тебя по каким-то причинам нет возможности поиграть блин... ");
            Scanner in = new Scanner(System.in);
            byte x = in.nextByte();
            do {
                if (x == 1) {
                    System.out.println("Супер, погнали!");
                    System.out.println("Введите максимальное кол-во попыток: ");
                    int inputTryCount = in.nextInt();
                    System.out.println("Введите максимальное число, которое может загадать компьютер");
                    int inpetMaxValue = in.nextInt();
                    game(inputTryCount, inpetMaxValue);
                    tryAgain();
                } else if (x == 2) {
                    System.out.println("Обидно, конечно, ну да ладно, счастливо, дружище!");
                    return;
                } else {
                    System.out.println("Введи 1 или 2, что сложного то???");
                    x = in.nextByte();
                }
            } while (x != 1 || x != 2);
        } catch (InputMismatchException t) {
            System.out.println("ЧЕЕЕЕЕЕЕРТ! Введи число!!!! 1 или 2!!!");
            tryAgain();
        }
    }

    static void lalkaAnswer() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int indexWords = (int) (Math.random() * words.length);
        String answer = words[indexWords];
        Scanner scanner = new Scanner(System.in);
        int tryCount = 1;
        String[] buffer = new String[100];

        do {
            System.out.println("Угадайте загаданное слово\nэто одно из следующих слов\n" + Arrays.toString(words) + "\nВведите Ваш ответ: ");
            String inWord = scanner.nextLine();
            inWord = inWord.toLowerCase();
            buffer[tryCount - 1] = inWord;
            if (answer.equals(inWord)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                StringBuilder hint = new StringBuilder("###############");
                for (int i = 0; i < answer.length(); i++) {
                    if (i >= inWord.length()) break;
                    if (answer.charAt(i) == inWord.charAt(i)) hint.insert(i, answer.charAt(i));
                }
                System.out.println(hint.toString());
                System.out.println("Вы пробовали следующие варианты: " + Arrays.toString(buffer));
                ++tryCount;

            }
        } while (true);
    }
}
