package lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ты никогда не вершь?");
        String s = in.nextLine();
        int userInput = in.nextInt();
        if (userInput > 100500) {

        } else {

        }
        if (s.equals("да")) {
            System.out.println("Зачем ты меня обманул?");
        } else {
            System.out.println("OK");
        }
    }
}
