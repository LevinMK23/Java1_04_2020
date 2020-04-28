package lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        new gui_form().getButton1().addActionListener(ac -> {
            System.out.println("Hello world");
        });
    }
}
