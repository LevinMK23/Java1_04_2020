package Mylesson1;

import java.util.Scanner;

//Задание 7
public class HelloJack {

    public static void Hello(String name){
        System.out.println("Привет, " + name + "!");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Hello(name);
    }
}
