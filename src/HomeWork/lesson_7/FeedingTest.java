package HomeWork.lesson_7;

import lesson5.CatColor;

import java.util.ArrayList;
import java.util.Random;

public class FeedingTest {
    public static void main(String[] args) {
        Random rnd = new Random();
        Plate plate = new Plate(250);
        plate.info();
        
        int totalCats = 7;
        ArrayList<Cat> cats = new ArrayList<Cat>();
        for (int i = 0; i <totalCats ; i++) {
            cats.add(new Cat((CatNames.values()[rnd.nextInt(CatNames.values().length)]).toString(), rnd.nextInt(100) ));
        }

        for(Cat cat: cats){
            cat.eat(plate);
            cat.isFull();
        }
        plate.info();
        plate.addFood(100);
        plate.info();



    }
}
