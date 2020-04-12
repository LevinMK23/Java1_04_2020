package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkGameTwo {

    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        guessWord();
    }

    private static void guessWord() {
        int n = random.nextInt(words.length);
        System.out.println("Hi!\nLets play a game\nI will pick a word and you need to guess\nLet the game begin!");
        //System.out.println("Shhh.... hidden word: " + words[n]);
        char[] letters = words[n].toCharArray();
        char[] hash = new char[15];
        Arrays.fill(hash, '#');
        playLevel(words[n], letters, hash);
    }

    private static void playLevel(String hiddenWord, char[] letters, char[] hash) {
        String word;
        while (true) {
            System.out.println("Word: " + String.valueOf(hash));
            System.out.print("Enter the word (or press 0 to quit): ");
            word = scanner.nextLine();
            if (word.equals("0")) {
                break;
            }
            if (word.equals(hiddenWord)) {
                System.out.println("Word: " + hiddenWord);
                System.out.println("You win!!!");
                break;
            } else {
                System.out.println("Hmmm... that's not right. Try again:");
                char[] userLetters = word.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    if (i >= userLetters.length) {
                        break;
                    }
                    if (letters[i] == userLetters[i]) {
                        hash[i] = letters[i];
                    }
                }
            }
        }
    }

}