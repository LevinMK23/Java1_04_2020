package lesson3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        do {
            int count = 0;
            int guess = 1;
            int number = random.nextInt(1001);
            while (count < 10 && guess != number) {
                System.out.println(
                        "Попытка [" + (count + 1) + "] угадай чисто от 0 до 1000): ");
                try {
                    guess = scanner.nextInt();
                    if (number == guess) {
                        System.out.println("Ты победил!");
                    } else {
                        if (guess < number){
                            System.out.println("Твоё число меньше загаданного.");
                        }
                        else System.out.println("Твоё число больше загаданного.");
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (count == 10)
                System.out.println("Ты проиграл. Загаданное число было - " + number);
            System.out.print("Будешь играть заново?\n[1 - yes / 0 - no]: ");
        }
        while (scanner.next().equals("1"));
    }
}

