package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GuessTheWord {
    public static void main(String[] args) throws IOException {
        String[] word = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int i = (int) (Math.random() * word.length);
        String wrd = word[i];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder hint = new StringBuilder();
        System.out.println("Угадайте слово из следующего списка: " + Arrays.toString(word));

        while (true) {
            String userword = reader.readLine();
            if (userword.equals(wrd)) {
                System.out.println("Вы угадали. Поздравляем!!!");
                break;
            } else for (int j = 0; j < 15; j++) {
                if ((j < wrd.length()) && (j < userword.length()) && (userword.charAt(j) == wrd.charAt(j))) {
                    hint.append(userword.charAt(j));
                } else {
                    hint.append('#');
                }
            }
            System.out.println("Подсказка: " + hint);
            hint.delete(0, hint.length());
        }
        System.out.println("Игра окончена");
    }
}