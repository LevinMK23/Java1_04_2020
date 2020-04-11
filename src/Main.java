
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    //Использовать одну переменну во всех методах, в данном случае - хорошо или плохо? Когда так стоит делать и когда не стоит?
    static int userAnswer = 1;

    static void method1() {
        int tryCount = 3;
        System.out.println("Программа закадала число от 0 до 9, попробуйте его угадать! У вас есть 3 попытки.");
        while (userAnswer == 1) {
            int number = (int) (Math.random() * 10);
            for (int i = 0; i < tryCount; i++) {
                System.out.println("Введите число от 0 до 9, а программа проверит, угадалили вы: ");
                userAnswer = scanner.nextInt();
                if (userAnswer == number) {
                    System.out.println("Поздравляю, вы угадали!\nПовторить игру еще раз? 1 – да / 0 – нет");
                    userAnswer = scanner.nextInt();
                } else if (userAnswer < number) {
                    System.out.println("Загаданное число больше, попробуйте еще раз!");
                } else {
                    System.out.println("Загаданное число меньше, попробуйте еще раз!");
                }
            }
            System.out.println("Вы проиграли, но не расстраивайтесь, у вас все получится!\nПовторить игру еще раз? 1 – да / 0 – нет");
            userAnswer = scanner.nextInt();
        }
    }

    static void method2() {
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String selectedWord = words[(int) (Math.random() * 25)];
        System.out.println("Программа закадала слово, попробуйте его угадать!");

        while (true) {
            //Не сработало, пришлось заводить новую переменную, почему?
            //Integer.toString(userAnswer) = scanner.next();
            String userAnswer = scanner.next();
            if (userAnswer.equals(selectedWord)) {
                System.out.println("Поздравляю, вы угадали!");
                break;
            } else {
                int exceptionSymbolsCount = 15;
                try {
                    for (int i = 0; i < 15; i++) {
                        if (selectedWord.charAt(i) == userAnswer.charAt(i)) {
                            System.out.print(selectedWord.charAt(i));
                        } else {
                            System.out.print("#");
                        }
                        exceptionSymbolsCount--;
                    }
                } catch (Exception e) {
                    //Как это сделать через стрингбилдер?
                    for (int i = 0; i < exceptionSymbolsCount; i++) {
                        System.out.print("#");
                    }
                }
            }

        }
    }

    //psvm public static void main
    public static void main(String[] args) {
        //sout
        System.out.println("Какой метод вы хотите запустить?\n 1 - метод Угадай число / 0 - метод Угадай слово");
        userAnswer = scanner.nextInt();
        if (userAnswer == 1) {
            method1();
        } else if (userAnswer == 0) {
            method2();
        } else {
            System.out.println("От многой мудрости много скорби, и умножающий знание - умножает печаль. :D");
        }
    }
}
