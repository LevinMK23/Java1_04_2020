package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    private static final String[] words = {"apple", "apricot", "avocado", "banana",
            "broccoli", "carrot", "cherry", "garlic", "grape", "kiwi", "leak", "lemon",
            "mango", "melon", "mushroom", "nut", "olive", "orange", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private static final Random rnd = new Random();

    public static void main(String[] args) {
        task2();
    }

    public static void task2() {

        System.out.println("Угадай слово, которое я загадал");
        String winWorld = words[rnd.nextInt(words.length)];
        char[] chars = new char[15];
        Arrays.fill(chars, '#');
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Введи слово: ");
            String word = in.next();
            word = word.toLowerCase();

            if (word.equals("exit")) {
                return;
            }

            if (word.equals(winWorld)) {
                System.out.println("Победа! Я загадал: " + winWorld);
                System.out.println("Выход: exit");
                System.out.println("Новая игра: game");
                String command = in.next();
                switch (command) {
                    case "exit":
                        return;
                    case "game":
                        System.out.println("Новая игра:");
                        winWorld = words[rnd.nextInt(words.length)];
                        Arrays.fill(chars, '#');
                        continue;
                    default:
                        return;
                }
            }

            for (int i = 0; i < winWorld.length(); i++) {
                if (i < word.length() && winWorld.charAt(i) == word.charAt(i)) {
                    chars[i] = word.charAt(i);
                }
            }
            for (int i = 0; i < 15; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
}
