package lesson3.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGame {

    private static final String[] words = {"apple", "orange", "lemon",
            "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi",
            "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private static final Random rnd = new Random();

    public static void game() {
        System.out.println("Я загадал слово, попробуй его угадать");
        String pcWord = words[rnd.nextInt(words.length)];
        char [] chars = new char[15];
        Arrays.fill(chars, '#');
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введи свой вариант: ");
            String word = in.next();
            word = word.toLowerCase();
            if (word.equals("quit")) {
                return;
            }
            if (word.equals(pcWord)) {
                System.out.println("Ты угадал, я загадал: " + pcWord);
                System.out.println("Выход: 1");
                System.out.println("Новая игра: 2");
                String command = in.next();
                switch (command) {
                    case "1":
                        return;
                    case "2":
                        System.out.println("Новая игра:");
                        pcWord = words[rnd.nextInt(words.length)];
                        Arrays.fill(chars, '#');
                        continue;
                }
            }
            //banana
            //#a#a##########
            for (int i = 0; i < pcWord.length(); i++) {
                if (i < word.length() && pcWord.charAt(i) == word.charAt(i)) {
                    chars[i] = word.charAt(i);
                }
            }
            for (int i = 0; i < 15; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        game();
    }
}
