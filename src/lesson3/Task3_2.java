package lesson3;

import java.util.Scanner;

public class Task3_2 {
    public static void main(String[] args) {
        guessWord(new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"});
    }

    private static void guessWord(String[] words) {
        String hiddenWord = words[(int)(Math.random() * words.length)];
        System.out.print("Добро пожаловать в поле чудес. Вам нужно отгадать слово, при неверном ответе вы увидите буквы которые стоят в правильных местах.\nВведите слово: ");
        Scanner userIn = new Scanner(System.in);
        String userAnswer = userIn.next().toLowerCase();
        int tryCount = 1;
        while (!userAnswer.equals(hiddenWord)) {
            tryCount++;
            StringBuilder hint = new StringBuilder();
            for (int i = 0; i < userAnswer.length(); i++) {
                if (hiddenWord.charAt(i) == userAnswer.charAt(i)) {
                    hint.append(userAnswer.charAt(i));
                } else {
                    hint.append("#");
                }
            }
                while (hint.length() < 15) {
                    hint.append("#");
                }
                System.out.printf("Неверно! Подсказка: %s.\nВведите слово: ", hint);
                userAnswer = userIn.next().toLowerCase();
        }
        System.out.printf("Угадали. Всего попыток: %d", tryCount);
    }
}
