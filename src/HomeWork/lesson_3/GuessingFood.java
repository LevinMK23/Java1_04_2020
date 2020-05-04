package HomeWork.lesson_3;
//task_2
//* Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot",
// "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
// "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
// компьютер показывает буквы которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно, можно пользоваться:
//String str = "apple";
//str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово
//Используем только маленькие буквы

import java.util.Scanner;

public class GuessingFood {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        playGame(words);
    }

    private static void playGame(String[] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess what grows on the farm?");
        String randomFood = arr[(int) (Math.random() * (arr.length - 1))];
        while (true){
            String inputWord = scanner.nextLine();
            inputWord = inputWord.toLowerCase();
            if (inputWord.equals("q")) return;
            if (inputWord.equals(randomFood)) {
                System.out.println("You guessed right!");
                return;
            } else {
                showLetters(randomFood, inputWord);
            }
        }
    }
    private static void showLetters(String randFood, String inputWord){
        System.out.println("Guessed letters are shown here:");
        char[] word = new char[15];
        //dif - кол-во букв в наименьшем из двух слов
        int dif;
        if (randFood.length() < inputWord.length()) dif = randFood.length();
        else dif = inputWord.length();
        for (int i = 0; i < dif ; i++) {
            if (randFood.charAt(i) == inputWord.charAt(i)) word[i] = inputWord.charAt(i);
            else word[i] = '#';
        }
        for (int i = dif; i <15 ; i++) word[i] = '#';
        System.out.println(word);
        System.out.println("Try one more time or tap 'q' to exit.");
    }
}

