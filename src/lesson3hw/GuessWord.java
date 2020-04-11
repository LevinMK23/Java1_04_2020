package lesson3hw;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {

    static void guessWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        int guessIndex = rand.nextInt(words.length);
        String guessWord = words[guessIndex];
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Угадайте загаданное слово: ");
            String inWord = scanner.nextLine().toLowerCase();
            if (guessWord.equals(inWord)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                StringBuilder hint = new StringBuilder("###############");
                for (int i = 0; i < guessWord.length(); i++) {
                    if (i >= inWord.length()) break;
                    if (guessWord.charAt(i) == inWord.charAt(i)) hint.setCharAt(i, guessWord.charAt(i));
                }
                System.out.println(hint);

            }
        } while (true);
        scanner.close();
    }

    public static void main(String[] args) {
        guessWord();
    }
}
