package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkGameTwoVerTwo {

    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static String word;

    public static void main(String[] args) {
        welcome();
    }

    private static void welcome() {
        System.out.println("Hi!\nWelcome to the game 'Guess My Word'" +
                "\nI will pick a word and you need to guess" +
                "\nAre you ready?" +
                "\n0 - QUIT" +
                "\n1 - START");
        String main;
        main = scanner.nextLine();
        if (main.equals("0")) {
            quit();
        } else if (main.equals("1")) {
            task();
        } else {
            welcome();
        }
    }

    private static void task() {
        System.out.println("Let the game begin!\n");
        int n = random.nextInt(words.length);
        System.out.println("Shhh.... hidden word: " + words[n]);
        char[] letters = words[n].toCharArray();
        char[] hash = new char[letters.length];
        Arrays.fill(hash, '#');
        System.out.println("Guess the word:\n\n" + String.valueOf(hash) + "\n");
        System.out.println("Are you ready to announce the whole word or you want to try to guess letters?" +
                "\nIf you will choose first way then you will have only one chance" +
                "\nBut if you will choose second way, you will have many tries");
        choice(words[n], letters, hash);
    }

    private static void choice(String hiddenWord, char[] letters, char[] hash) {
        System.out.println("\n1 - WHOLE WORD\n2 - GUESS LETTERS");
        String main;
        main = scanner.nextLine();
        if (main.equals("1")) {
            word(hiddenWord);
        } else if (main.equals("2")) {
            letters(hiddenWord, letters, hash);
        } else {
            task();
        }
    }

    private static void word(String hiddenWord) {
        System.out.print("Enter the whole word: ");
        word = scanner.nextLine();
        if (word.equals(hiddenWord)) {
            System.out.println("\nYOU WIN!!!\nThe secret word was:\n\n" + hiddenWord + "" +
                    "\n\nThank you for playing!\nI hope to see you next time. Bye.\n");
        } else {
            System.out.println("\nGAME OVER\n\nThe secret word was:\n\n" + hiddenWord + "\n");
        }
        repeat();
    }

    private static void letters(String hiddenWord, char[] letters, char[] hash) {
        int right = 0;
        String symbol = "#";
        while (String.valueOf(hash).contains(symbol)) {
            System.out.println("The secret word:\n\n" + String.valueOf(hash) + "\n");
            System.out.print("You can write a letter: ");
            word = scanner.nextLine();
            char userLetter = word.charAt(0);
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == userLetter) {
                    hash[i] = letters[i];
                    right = 1;
                }
            }

            if (right == 1) {
                if (!String.valueOf(hash).contains(symbol)) {
                    System.out.println("\nYOU WIN!!!\nThe secret word was:\n\n" + String.valueOf(hash) + "" +
                            "\n\nThank you for playing!\nI hope to see you next time.\nBye.");
                    break;
                } else {
                    System.out.println("\nMy congratulations! This word contain this letter!\n");
                    System.out.println(String.valueOf(hash) + "\n");
                    System.out.println("Are you ready to announce the whole word or " +
                            "you want to continue guessing letters?");
                    choice(hiddenWord, letters, hash);
                }
            } else {
                System.out.println("\nI'm so sorry but this word doesn't contain this letter.\nTry again.");
            }
        }
    }

    public static void repeat() {
        System.out.println("Do you want to repeat the game?\n1 - Yes | 0 - No");
        word = scanner.nextLine();
        int choice = Integer.parseInt(word);
        if (choice == 1) {
            welcome();
        } else if (choice == 0) {
            System.out.println("Goodbye!");
            quit();
        } else {
            repeat();
        }
    }

    public static void quit() {
        scanner.close();
    }

}
