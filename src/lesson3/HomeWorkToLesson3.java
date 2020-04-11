import java.util.Scanner;

public class HomeWorkToLesson3 {

    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        int number = (int) (1 + Math.random() * 1000); // генерируем число, которое будем угадывать
        int counter = 0; // попытки
        while (counter <= 10) {
            System.out.println("Введите число: ");
            int userAnswer = answer.nextInt();
            if (userAnswer > number) {
                System.out.println("Вы ввели большее число");
                counter++;
                if (counter == 11) { // проверяем закончились ли попытки у user`а
                    System.out.println("Извините, но у вас закончились попытки");
                    System.out.println("Вы хотите сыграть еще раз?");
                    System.out.println("1 - да, 2 - нет");
                    if (answer.nextInt() == 1) { // если да, то обнуляем попытки и генерируем новое число
                        counter = 0;
                        number = (int) (1 + Math.random() * 1000);
                    }
                }
            } else if (userAnswer < number) {
                System.out.println("Вы ввели меньшее число");
                counter++;
                if (counter == 11) {
                    System.out.println("Извините, но у вас закончились попытки");
                    System.out.println("Вы хотите сыграть еще раз?");
                    System.out.println("1 - да, 2 - нет");
                    if (answer.nextInt() == 1) {
                        counter = 0;
                        number = (int) (1 + Math.random() * 1000);
                    }
                }
            } else if (userAnswer == number) {
                System.out.println("Поздравляем вы отгадали!");
                System.out.println("Вы хотите сыграть еще раз?");
                System.out.println("1 - да, 2 - нет");
                if (answer.nextInt() == 1) {
                    counter = 0;
                    number = (int) (1 + Math.random() * 1000);
                } else counter = 11;

            }
        }
    }
}
