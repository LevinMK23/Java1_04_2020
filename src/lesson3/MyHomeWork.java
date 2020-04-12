package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Java1 уроук 3 домашнее задание
 * @author Михаил Новиков
 * @author mnovikov37@gmail.com
 * @version 1.0
 */
public class MyHomeWork {

    /**
     * Игра на угадывание одного слова из заданного массива.
     * Подсказывает, какие буквы в ответе игрока совпадают с загаданным словом.
     * Завершается либо при угадывании слова, либо при введениии в качестве ответа слова break
     * @param arr массив слов, из которых нужно угадать одно
     * @throws IOException
     */
    static void task2(String[] arr) throws IOException {

        // Приветствие и объяснение пользователю правил игры
        System.out.println("Guess one word from the list:");
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

        // Случайное слово из исходного списка выбирается в качестве правильного ответа
        String answer = arr[(int) (Math.random()*arr.length)];

        // Выделение переменной для храненеия ответа пользователя
        String userAnswer = "";

        // Инициализация объекта ввода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Цикл игры: пользователь вводит ответы, пока не угадает или не прервёт игру
        while(!userAnswer.equals("break")){
            System.out.println("Your answer (enter \"break\" for exit):");
            userAnswer = reader.readLine();
       //     System.out.println(answer + " " + userAnswer);
            if(userAnswer.equals(answer)){
                System.out.println("Yes, it's " + userAnswer);
                break;
            } else if(userAnswer.equals("break")){
                System.out.println("Game over");
                break;
            } else {
                System.out.println("Answer is not correctly. Matched symbols (count may be less):");
                for (int i = 0; i < 15 ; i++) {
                    if(i < answer.length() && i < userAnswer.length() && userAnswer.charAt(i) == answer.charAt(i)){
                        System.out.print(answer.charAt(i));
                    } else{
                        System.out.print('#');
                    }
                }
                System.out.println();
            }
        }

    }

    /**
     * Точка входа в программу
     * @param args параметры не требуются
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        task2(words);
    }
}
