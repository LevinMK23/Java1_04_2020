package HomeWork7;

public class CatWantToEat {
    public static void main(String[] args) {
        Plate plate = new Plate(1000, 80);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Котя 1", 50);
        cats[1] = new Cat("Котя 2", 30);
        cats[2] = new Cat("Котя 3", 27);
        cats[3] = new Cat("МУРРРЗИК", 100);

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
