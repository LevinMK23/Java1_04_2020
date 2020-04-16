package ru.geekbrains.lesson3_homework;

import java.util.Scanner;

public class lesson3_homework_Alexandr_Smirnov {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        playgame();
        while (true) {
            System.out.println("Сыграть еще раз? 1 - Да. 0 - Нет");
            int answer = scanner.nextInt();
            if (answer == 1) {
                playgame();
            } else {
                System.out.println("Спасибо за игру!");
                break;
            }
        }
    }



public static void playgame() {
    System.out.println("Угадайте число от 0 до 9. У Вас три попытки.");
    int a = 9;
    int number = (int)(Math.random() * a);
    Scanner scanner = new Scanner (System.in);
    for (int i = 0; i < 3; i++) {
        int input_number = scanner.nextInt();
        if(input_number == number) {
            System.out.println("Вы угадали!");
            return;
        } else if (input_number > number) {
            System.out.println("Загаданное число меньше");
        } else {
            System.out.println("Загаданное число больше");
        }
    }
    System.out.println("Вы проиграли.");
    return;
    }
}