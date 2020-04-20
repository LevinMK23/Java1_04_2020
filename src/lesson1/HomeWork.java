package lesson1;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println(task_03(-2.2f, 4, 6.4f, 8.2f)); //Задайте входные параметры для задания 3
        System.out.println(task_04(5, 10)); //Задайте входные параметры для задания 4
        task_05(-2); //Задайте число для задания 5
        System.out.println(task_06(-5));//Задайте число для задания 6
        task_07("Slava");//Напишите любое имя для задания 7
        task_08(2020 );//Напишите любой год для задания 8

    }

    public static float task_03 (float a, float b, float c, float d) {
        return (a*(b+(c/d)));
    }//Метод для выполнения задания 3

    public static boolean task_04 (int a, int b) {
        return (a + b) > 10 && (a + b) <= 20;
    }//Метод для выполнения задания 4

    public static void task_05 (int a) {
        if (a >= 0) {
            System.out.println("number +");
        }
        else {
            System.out.println("number -");
        }
    }//Метод для выполнения задания 5

    public static boolean task_06 (int a) {
        return a < 0;
    }//Метод для выполнения задания 6

    public static void task_07 (String name ) {
        System.out.println("Привет, " + name + "!");
    }//Метод для выполнения задания 7

    public static void task_08 (int a) {
        if ( a % 400 == 0) {
            System.out.println("Високосный год");
            return;
        }
        if ( a % 4 == 0 && a % 100 != 0 ) {
            System.out.println("Високосный год");
        }
        else {
            System.out.println("Не является високосным годом");
        }
    }//Метод для выполнения задания 8
}



