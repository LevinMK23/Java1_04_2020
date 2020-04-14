package lesson3;

import java.util.Scanner;

public class Game_Numbers {

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        int health = 10;
        int yes = 1;
        int no = 0;
        int result = 0;
        while (true) {
            int counter = 0;
            System.out.println("Ваша задача - угадать число от 0 до 1000! У вас " + health + " жизней");
            int randomNumber = (int) (Math.random() * 1001);
            System.out.println(randomNumber);
            while (counter < health) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите число");
                int userNumber = scanner.nextInt();
                if (randomNumber > userNumber) {
                    counter++;
                    System.out.println("Ваше число меньше загаданного.\nУ вас осталось " + (health - counter) + " жизни");
                }
                if (randomNumber < userNumber) {
                    counter++;
                    System.out.println("Ваше число больше загаданного.\nУ вас осталось " + (health - counter) + " жизни");
                }

                if (randomNumber == userNumber) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Вы выиграли!!! Повторить игру еще раз?\nДля продолжения введите " + yes + " - да\nдля выхода из игры нажмите " + no + " - нет");
                    result = scan.nextInt();
                    break;
                }
            }
            if (counter == health) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Вы проиграли((( Повторить игру еще раз?\nДля продолжения введите " + yes + " - да\nДля выхода из игры нажмите " + no + " - нет");
                result = scan.nextInt();
            }

            if (result == no) return;
        }
    }

}




