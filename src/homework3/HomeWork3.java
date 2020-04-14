package homework3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static Random rnd = new Random();
    public static Scanner scn = new Scanner(System.in);

    public static void task1() {
        int tryNumber = 3;
        int number;
        int input;

        while (true) {
            System.out.println("Task1: Game \"Guess the number\"");
            number = rnd.nextInt(9);
            tryNumber = 3;
            while (tryNumber > 0) {
                input = scn.nextInt();

                if (input == number) {
                    System.out.println("Good job!");
                    System.out.println("Retry?");
                    input = scn.nextInt();
                    if (input == 0) {
                        System.out.println("GoodBye!");
                        return;
                    } else {
                        break;
                    }
                } else {
                    if (input < number) {
                        System.out.println("Your number is lesser than computer's");
                    } else if (input > number) {
                        System.out.println("Your number is greater than computer's");
                    }
                    tryNumber--;
                }

                if (tryNumber == 0) {
                    System.out.println("Number = " + number);
                    System.out.println("No more retries left");
                    System.out.println("Restart?");

                    input = scn.nextInt();
                    if (input == 0) {
                        System.out.println("GoodBye!");
                        return;
                    }
                }
            }
        }

    }

    public static void task2() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        int wordIndex = rnd.nextInt(words.length);

        String input;
        System.out.println("Task2: Game \"Guess the word\"");

        while (true) {
            input = scn.next();
            if (input.equals(words[wordIndex])) {
                System.out.println("Good job!");
                return;
            } else {
                int length = Math.min(input.length(), words[wordIndex].length());
                length = Math.min(length, 15);
                StringBuilder tmp = new StringBuilder("###############");
                for (int i = 0; i < length ; i++) {
                    if (input.charAt(i) == words[wordIndex].charAt(i)) {
                        tmp.setCharAt(i, input.charAt(i));
                    }
                }

                System.out.printf("You are wrong! Hint: %s. Try again.\n", tmp);
            }
        }

    }

    public static void main(String[] args) {
    }
}
