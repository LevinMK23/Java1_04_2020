package HomeWork7;

import lesson7.persons.Student;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Plate plate = new Plate(100);
        plate.addFood(2);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik", 5));
        cats.add(new Cat("Мурзик", 65));
        cats.add(new Cat("Васька", 35));

        //Покормим котиков
        for (Cat c:cats) {
            c.eat(plate);
            System.out.println(c.getName() +" сытость = "+ c.isSatiety());
        }

    }


}
