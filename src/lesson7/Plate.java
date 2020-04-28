package lesson7;

import java.util.Scanner;

public class Plate{

    private int food;
    static boolean starv;

    public Plate(int food){
        this.food = food;
    }

    public void decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            starv = true;
        } else {
            System.out.println("Еды в тарелке не достаточно: " + food);
            starv = false;
        }
    }


    public void info(){
        System.out.println("В тарелке еды: " + food);
    }

    public int setFood(int food){
        return food;
    }

    public int addFood() {
        Scanner in = new Scanner(System.in);
        int check = in.nextInt();
        if (check == 0) {
            System.out.println("Мы ничего не добавили в тарелку :( ");
            info();
        } else {
            food += check;
            System.out.println("Мы добавили еду в тарелку!");
            info();
        }
        return food;
    }


    public int getFood() {
        return food;
    }
}
