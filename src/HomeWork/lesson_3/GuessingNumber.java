package HomeWork.lesson_3;

//task_1
//Написать программу, которая загадывает случайное число от 0 до 1000 и пользователю дается
// 10 попыток угадать это число. При каждой попытке компьютер должен сообщить, больше ли
// указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
// выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

import java.util.Scanner;

public class GuessingNumber {

    public static void main(String[] args) {
        gameBody();
    }
    private static void gameBody(){
        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 1000) ;
        System.out.println("Угадай число от 0 до 1000!");
        for (int i = 10; i > 0; i--) {
            System.out.println("Осталось " + i + " попыток. \nДля выхода нажмите '-1'.");
            int inputNumber = scanner.nextInt();
            if (inputNumber == -1){
                repeatGame();
                return;
            }
            if (inputNumber == randomNumber) {
                System.out.println("Ты угадал!");
                repeatGame();
            }
            System.out.println(inputNumber < randomNumber ? "Загаданное число больше": "Загаданное число меньше");
        }
        System.out.println("Это число: " + randomNumber);
        repeatGame();
    }
    private static void repeatGame(){
        System.out.println("Повторить игру еще раз? 1 - да, 0 - нет.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 0){
            return;
        }
        if (choice == 1) gameBody();
    }
}


