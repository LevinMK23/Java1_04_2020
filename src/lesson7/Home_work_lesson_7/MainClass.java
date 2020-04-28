package lesson7.Home_work_lesson_7;

import java.lang.reflect.Array;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        Plate plate = new Plate(0);
        System.out.println("Покормить котов? 1 - (Да) , 0 - (Нет)");
        while(true) {
            int replayEat = scan.nextInt();
            if (replayEat == 1) {
                plate.info();
                System.out.println("--------------------");
                plate.fullPlate();
                plate.info();
                System.out.println("--------------------");
            }
            if (replayEat == 0) {
                return;
            }
            if (replayEat >1 || replayEat < 0) {
                return;
            }

            System.out.println("Чтобы поставить тарелку котам нажмите 1 ");
            System.out.println("Если передумали кормить, нажмите любую другую цифру");
            int giveFood = scan.nextInt();
            if (giveFood == 1) {

                Cat[] arr = new Cat[5];
                arr[0] = new Cat("Barsik", 5);
                arr[1] = new Cat("Musia", 10);
                arr[2] = new Cat("Tolstiachok", 80);
                arr[3] = new Cat("Murzic", 12);
                arr[4] = new Cat("Klepa", 7);

                plate.info();
                System.out.println("--------------------");
                for (int i = 0; i < arr.length; i++) {
                    arr[i].infoCat();
                    arr[i].eat(plate);
                    plate.info();
                    System.out.println("--------------------");
                }


            }
            else return;
            System.out.println("Покормить котов еще раз? 1 - (Да) , 0 - (Нет)");
        }
    }
}
