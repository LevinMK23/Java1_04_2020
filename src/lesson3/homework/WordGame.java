package Lesson3_HW3;
    // Угадай число. Компьютер «загадывает» целое число от 0 до 9, а Вы должены угадать его за три попытки.
    import java.util.Random;
    import java.util.Scanner;

 public class GuessTheNumberHW3 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
    //private Scanner random;
        int count = 0;
        int guess = -1;
        int number = random.nextInt(10);
        while (count < 3 && guess != number) {
            System.out.println("Угадайте число от 0 до 9.");
            guess = sc.nextInt();
            if(number != guess) {   // наш номер и рандомный
                System.out.println("Ваш номер " + ((guess > number) ? "больше" : "меньше "));
                count++; // попытки.
            }
        }
        System.out.println("Вы " + ((guess == number)? "выйграли!" : "проиграли " + number));
    }
}
