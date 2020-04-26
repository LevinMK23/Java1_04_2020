package lesson7.HomeWork;

public class FeedCatTest {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Barsik", 7);
        cats[1] = new Cat("Jenya", 12);
        cats[2] = new Cat("Victor", 30);
        Plate plate1 = new Plate(40);
        for (Cat cat : cats) {
            cat.eat(plate1);
            cat.satietyInfo();
        }
        plate1.addFood(9);
        plate1.info();
        cats[2].eat(plate1);
        cats[2].satietyInfo();
        plate1.info();
    }
}
