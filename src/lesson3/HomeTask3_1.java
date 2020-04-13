package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class HomeTask3_1 {
    public static void main(String[] args) throws IOException {
        new HomeTask3_1().guessWord();


    }

    public void guessWord() throws IOException {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random randomFood = new Random();
        int random = randomFood.nextInt(words.length);
        do {
            String word = words[random];
            System.out.println("Угадай слово из перечисленных: " + Arrays.toString(words));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String reader = bufferedReader.readLine();
            if (word.equals(reader))
                System.out.println("Ты угадал!!!");
            else {
                char[] yourAnswer = reader.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    if (j >= yourAnswer.length) break;
                    if (word.charAt(j) != yourAnswer[j]) yourAnswer[j] = '#';
                }
                StringBuilder hashtag = new StringBuilder(String.valueOf(yourAnswer));
                for (int k = hashtag.length(); k < 15; k++) hashtag.append("#");
                System.out.println(hashtag);

            }
        } while (true);

    }

}


