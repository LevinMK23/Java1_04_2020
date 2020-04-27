package LessonOOP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Scanner scn1 = new Scanner(System.in);
        String sccn = "";
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Bars", 5);
        cat[1] = new Cat("Java", 5);
        cat[2] = new Cat("C++", 5);
        cat[3] = new Cat("Python", 6);
        cat[4] = new Cat("Assembler", 5);
        Plate plate = new Plate(20);
        plate.info();
        for (Cat value : cat) {
            if ((plate.getFood() - value.getAppetite()) <= 0) {
                System.out.println("В миске недостаточно еды!");
                System.out.println("Хотите положить еще еды?");
                sccn = scn.nextLine();
                if (sccn.equalsIgnoreCase("да")) {
                    plate.plusFood(scn1.nextInt());
                    value.eat(plate);
                }
                else break;
            } else value.eat(plate);
            System.out.println("Сытость кота " + value.getName() + ":" + value.isHungry());
        }
        plate.info();
    }
}
