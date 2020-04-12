package lesson3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeworkGameOne {

    private static Scanner scanner = new Scanner(System.in);
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static Matcher matcher = null;

    public static void main(String[] args) {
        guessTheNumber();
    }

    private static void guessTheNumber() {
        int range = 9;
        int lives = 3;
        System.out.println("Hi!\nLets play a game\nI will pick a number and you need to guess\nYou will have only " + lives + " tries to guess the number\nLet the game begin!");
        for (int i = 0; i <= range ; i += 1) {
            playLevel(i, lives, range);
        }
        System.out.println("You win!!!");
        repeat();
    }

    private static void playLevel(int nm, int lives, int range) {
        int number = (int)(Math.random() * nm);
        System.out.println("Please, enter the number in range 0-" + range + ":");
        //System.out.println("Shhh.... hidden number: " + number);
        while (lives > 0) {
            String stringNum = scanner.nextLine();
            matcher = pattern.matcher(stringNum);
            if (matcher.matches()) {
                int input_number = Integer.parseInt(stringNum);
                if (input_number == number) {
                    System.out.println("You are right but we are not done yet...");
                    break;
                } else {
                    lives -= 1;
                    if (lives > 0) {
                        if (input_number < number) {
                            System.out.println("Entered number is lower");
                        } else {
                            System.out.println("Entered number is higher");
                        }
                        if (lives > 1) {
                            System.out.println("You have " + lives + " tries left\nLets try again.");
                        } else {
                            System.out.println("You have only " + lives + " try left\nLets try again. But be careful with your choice.");
                        }
                        System.out.println("Enter the number:");
                    } else {
                        System.out.println("GAME OVER");
                        repeat();
                    }
                }
            } else {
                System.out.println("Very funny but lets use only numbers\nEnter the number:");
            }
        }
    }

    public static void repeat() {
        System.out.println("Do you want to repeat the game?\n1 - Yes | 0 - No");
        String stringNum = scanner.nextLine();
        matcher = pattern.matcher(stringNum);
        if (matcher.matches()) {
            int choice = Integer.parseInt(stringNum);
            if (choice == 1) {
                guessTheNumber();
            } else if (choice == 0) {
                System.out.println("Goodbye!");
                scanner.close();
            } else {
                repeat();
            }
        } else {
            System.out.println("Very funny! Please, use only numbers...");
            repeat();
        }
    }

}
