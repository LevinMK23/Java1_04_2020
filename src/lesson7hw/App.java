package lesson7hw;

public class App {
    public static void main(String[] args) {

        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Barsik", 10);
        catArray[1] = new Cat("Murzik", 20);
        catArray[2] = new Cat("Stepan", 15);
        catArray[3] = new Cat("Ugol", 10);
        catArray[4] = new Cat("Begemot", 20);

        Plate plate = new Plate(30);

        for (Cat cat : catArray) {
            cat.eat(plate);
            cat.info();
        }
        plate.info();
        plate.addFood(40);
        plate.info();
    }
}