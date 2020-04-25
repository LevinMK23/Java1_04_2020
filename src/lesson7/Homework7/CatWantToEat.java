package lesson7.Homework7;

public class CatWantToEat {
    public static void main(String[] args) {
        Plate plate = new Plate(1000, 80);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Barsik", 50);
        cats[1] = new Cat("Humster", 30);
        cats[2] = new Cat("Bobafet", 27);
        cats[3] = new Cat("Sherlok", 100);

        plate.info();
        for (Cat cat : cats) {
            cat.getSatiety();
            cat.eat(plate);
            plate.info();
        }

        plate.addFoodToThePlate(-10);
        plate.addFoodToThePlate(50);
        plate.info();
        Plate plate2 = new Plate(-10, 1);
    }
}
