import java.util.Scanner;

public class HomeWorkToLesson3_part2 {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordsQuestion = (int) (Math.random() * words.length);
        String answer = "";
        while (!answer.equals(words[wordsQuestion])) {
            Scanner scn = new Scanner(System.in);
            answer = scn.nextLine();
            char[] answerChar = new char[answer.length()];
            for (int i = 0; i < answer.length(); i++) {
                answerChar[i] = answer.charAt(i);
            }
            char[] wordChar = new char[words[wordsQuestion].length()];
            for (int i = 0; i < words[wordsQuestion].length(); i++) {
                wordChar[i] = words[wordsQuestion].charAt(i);
            }
            for (int i = 0; i < answerChar.length; i++) {
                if (answerChar[i] != wordChar[i]) {
                    answerChar[i] = '#';
                }
            }
            if (!answer.equals(words[wordsQuestion])) {
                for (char c : answerChar) {
                    System.out.print(c);
                }
                System.out.print("###########");
                System.out.println();
            }
        }
        System.out.println("Поздравляю!");
    }
}
