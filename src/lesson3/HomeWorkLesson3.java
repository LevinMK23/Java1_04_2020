package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class HomeWorkLesson3 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int iAnswer;
    static String sAnswer;

    public static void main(String[] args) throws IOException {

        //task1();
        task2();
    }

    public static void task1() throws IOException {

        while (true) {
            beginGame();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            while (true) {
                iAnswer = Integer.parseInt(reader.readLine());
                if (iAnswer == 0) {
                    System.out.println("Игра закончена");
                    reader.close();
                    break;
                } else if (iAnswer == 1) {
                    System.out.println("Еще одна игра");
                    break;
                } else {
                    System.out.println("Введите 1 или 0");
                }
            }
            if (iAnswer == 0) break;
        }
    }

    public static void beginGame() throws IOException {

        int random = (int) (Math.random() * 1000);

        System.out.println("Отгадайте число от 0 до 1000 с десяти попыток");

        for (int i = 1; i <= 10; i++) {
            System.out.println("Попытка № " + i);
            iAnswer = Integer.parseInt(reader.readLine());

            if (random == iAnswer) {
                System.out.println("Вы угадали число " + random);
                return;
            }

            if (random < iAnswer)
                System.out.println("Загаданное число меньше введеного.");
            else
                System.out.println("Загаданное число больше введеного");
        }
        System.out.println("Попытки закончились, вы проиграли.");
    }

    public static void task2() throws IOException {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String word = words[(int) (Math.random() * (words.length - 1))];
        System.out.println("Введите слово");

        while (true) {
            sAnswer = reader.readLine();
            if (word.equals(sAnswer)) {
                System.out.println("Верно!");
                reader.close();
                return;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < Math.min(word.length(), sAnswer.length()) - 1; i++) {

                    if (word.charAt(i) == sAnswer.charAt(i))
                        sb.append(word.charAt(i));
                    else
                        sb.append('#');

                }

                if (sb.length() < 15) {
                    //+Подскажите пожалуйста каким методом какого класса возможно сделать это без цикла?
                    for (int i = sb.length(); i < 15; i++) sb.append('#');
                    //-
                }
                System.out.println(sb.toString());
            }
        }
    }
}


