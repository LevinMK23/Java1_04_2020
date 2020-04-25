package HomeWork_L7;

public class TestCatPalate {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 20);
        Cat cat2 = new Cat("Varvara", 20);
        Plate plate = new Plate(35);
        plate.info();
        cat1.eat(plate);
//        plate.info();
        cat2.eat(plate);
        plate.info();
        plate.addFood(30);
        plate.info();
    }
}
