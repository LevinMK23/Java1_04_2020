import java.util.Scanner;

public class NumberOne {
    public static void main(String[] args) {
        System.out.println("Я хочу сыграть с тобой в игру! Попробуй угадать загаданное мною число!" +
                "\nРазброс не большой - всего лишь от 0 до 1000. У тебя на всё про всё 10 попыток." +
                "\nСущий пустяк, я уверен, что ты справишься!");
        Scanner s = new Scanner(System.in);
        do {
            int randomNumber = (int) (Math.random() * 1000);
            int answer = -1; // Потому что 0 тоже может быть загадан
            int attempt = 10;
//            System.out.println(randomNumber); // Узнать какое число загадано
            while (attempt > 0 && answer != randomNumber) {
                System.out.println("\nВведите число: ");
                answer = s.nextInt();
                System.out.println("Ваше число" + (answer < randomNumber ? " меньше" : " больше") + ", чем загаданное");
                System.out.println("Осталось попыток: " + (--attempt));
            }
            System.out.println("Вы " + (answer == randomNumber ? "победили! " : "проиграли. ") + "Хотите сыграть ещё?\n1. Да\n2. Нет");
        } while (s.nextInt() == 1);
    }
}