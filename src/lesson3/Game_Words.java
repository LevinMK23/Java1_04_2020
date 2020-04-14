
package lesson3;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Game_Words {
    public static void main(String[] args) {
        String[] computerWord = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        //  StringBuilder result = new StringBuilder();
        System.out.println(Arrays.toString(computerWord) + "\nКомпьютер загадает одно из выведенных выше слов." +
                "\nВаша задача - отгадать это слово.");
        play(computerWord);
    }

    public static void play(String[] computerWord) {
        int numberWord = (int) (Math.random() * computerWord.length + 1);
       // System.out.println(computerWord[numberWord]);
        while (true) {
            StringBuilder result = new StringBuilder();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите слово");
            String userWord = scanner.nextLine();
            if (Objects.equals(userWord, computerWord[numberWord])) {
                System.out.println("Правильно! Молодец!!!");
                return;
            } else {
                char[] compare = new char[15];
                if (userWord.length() < computerWord[numberWord].length()) {
                    for (int i = 0; i < userWord.length(); i++) {
                        char a = userWord.charAt(i);
                        char b = computerWord[numberWord].charAt(i);
                        if (a == b) {
                            compare[i] = a;
                        } else {
                            compare[i] = '#';
                        }
                        result.append(compare[i]);
                    }
                    for (int i = userWord.length(); i < compare.length; i++) {
                        compare[i] = '#';
                        result.append(compare[i]);
                    }
                }
                if (userWord.length() >= computerWord[numberWord].length()) {
                    for (int i = 0; i < computerWord[numberWord].length(); i++) {
                        char a = userWord.charAt(i);
                        char b = computerWord[numberWord].charAt(i);
                        if (a == b) {
                            compare[i] = a;
                        } else {
                            compare[i] = '#';
                        }
                        result.append(compare[i]);
                    }
                    for (int i = computerWord[numberWord].length(); i < compare.length; i++) {
                        compare[i] = '#';
                        result.append(compare[i]);
                    }
                }
                System.out.println(result + "\nОтвет неверный, попробуйте еще раз!");
            }
        }
    }
}






