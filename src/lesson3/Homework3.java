package lesson3;

import netscape.security.UserTarget;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. Написать программу, которая загадывает случайное число от 0 до 100*, и пользователю дается 5* попытки угадать это число.
 * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
 * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */
public class Homework3 {

    public static void main(String[] args) {

//        GuessGame();
        Scanner check = new Scanner(System.in);
        do {
            GuessGame();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (check.nextInt() == 1);
        }



    public static void GuessGame() {
        Random rand = new Random();
        int x = rand.nextInt(100); // можно изменять крайнюю границу диапозона
        Scanner sc = new Scanner(System.in);
        int j = 5; // кол-во попыток, можно изменять

        System.out.println("==============================================");
        System.out.println("Привет! Давай сыграем с тобой в 'Угадай число'");
        System.out.println("Число я уже загадал :) ");
        System.out.println("Было загадано число: " + x);
        System.out.println("");
        System.out.println("Количество твоих попыток равно " + j);
        System.out.println("==============================================");

        int i = 1; // начальный шаг попытки
        while (i < j+1) {
            if (i == j) {
                System.out.println("Последняя попытка, всё или ничего!");
            }
            System.out.println("Попытка " + i + "/" + j);
            System.out.print("Введите число от 0 до 100: ");
            int input = sc.nextInt(); // вводим число
            // System.out.println(input);

            if (input > x) {
                System.out.println("Загаданное число меньше");
                System.out.println("==============================================");
            } else if (input < x) {
                System.out.println("Загаданное число больше");
                System.out.println("==============================================");
            } else if (input == x) {
                System.out.println("Вы угадали!"); // Ломаем луп, если число угадано
                System.out.println("(╯ ° □ °) ╯ (┻━┻)");
                break;
            }

            i++; // увеличиваем попытку на один
        }
        if (i == j+1) {
            System.out.println("Было загадано число: " + x);
            System.out.println("Вы проиграли");
            System.out.println("( ͡° ͜ʖ ͡°)");
            System.out.println("==============================================");
        }
    }
}

