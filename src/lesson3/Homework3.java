package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        task2(in);

        in.close();
    }

    public static void task1(Scanner in) {
        Random r = new Random();
        int n, a;
        while (true) {
            n = r.nextInt(9);
            System.out.println("Угадайте число от 0 до 9:");
            for (int i = 2; i >= 0; i--) {
                a = in.nextInt();
                if (a < n) {
                    System.out.println("Загаданное число больше, осталось попыток " + i);
                } else if (a > n) {
                    System.out.println("Загаданное число меньше, осталось попыток " + i);
                } else {
                    System.out.println("Угадали!");
                    break;
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет ");
            if (in.nextInt() == 0) break;
        }
    }

    public static void task2(Scanner in) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random r = new Random();
        String str, a;
        System.out.println("Угадайте слово на английском. Используйте маленькие буквы. ");
        str = words[r.nextInt(words.length - 1)];

        while (true) {
            StringBuilder sb = new StringBuilder("###############");
            a = in.nextLine();
            if (a.equals(str)) {
                System.out.println("Угадали! " + str);
                break;
            } else {
                for (int i = 0; i < a.length(); i++) {
                    sb.insert(i, (a.charAt(i) == str.charAt(i)) ? a.charAt(i) : "#");
                    if (str.length() == i + 1) break;
                }
                System.out.println(sb.toString());
            }
        }
    }
}
