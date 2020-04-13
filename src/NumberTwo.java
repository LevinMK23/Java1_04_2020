import java.util.Arrays;
import java.util.Scanner;

public class NumberTwo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "\nleak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        do {
            int randomWord = (int) (Math.random() * words.length);
            System.out.println("Игра становится всё интереснее! Теперь попробуйте угадать СЛОВО! Колличество попыток не ограничено.");
            System.out.println("\nСлова учавствующие в игре:\n" + Arrays.toString(words) + "\n");
            System.out.println(words[randomWord]); // Узнать загаданное слово
            char[] wordSecret = words[randomWord].toCharArray();
            int secretRandom = (int) (Math.random() * 20);
            char[] secret = new char[wordSecret.length + secretRandom];
            for (int i = 0; i < wordSecret.length + secretRandom; i++) {
                secret[i] = '#';
            }
            System.out.println(Arrays.toString(secret));
            while (true) {
                System.out.print("Введите слово: ");
                String word = s.nextLine();
                if (word.equals("0")) {
                    break;
                }
                if (word.equals(words[randomWord])) {
                    System.out.println("Поздравляю, Вы угадали");
                    break;
                } else {
                    System.out.println("Увы, Вы не угадали");
                    char[] secretWord = word.toCharArray();
                    for (int i = 0; i < wordSecret.length; i++) {
                        if (i >= secretWord.length) {
                            break;
                        }
                        if (wordSecret[i] == secretWord[i]) {
                            secret[i] = wordSecret[i];
                        }
                    }
                    System.out.println(String.valueOf(secret));
                }
            }System.out.println("Хотите сыграть ещё?\n1. Да\n2. Нет");
        } while (s.nextInt() == 1);
    }
}
