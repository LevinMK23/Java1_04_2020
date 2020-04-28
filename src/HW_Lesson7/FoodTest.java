package lesson7.HW;

public class FoodTest {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Боб", 21),
                new Cat("Барсик", 18),
                new Cat("Васька", 11),
                new Cat("Икер", 30)
        };
        Plate plate = new Plate(100);

//        plate.addFood(100);

        System.out.println(plate);
        System.out.println("");
        System.out.println("Коты кушают");

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
        }
    }
}