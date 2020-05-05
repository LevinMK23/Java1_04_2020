package lesson7.homework;

public class FoodTest {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Соня");
        cats[1] = new Cat("Мышь");
        cats[2] = new Cat("Масик");
        for (Cat cat: cats) {
            System.out.println(plate);
            cat.eat(plate);
            System.out.println(cat);
            if (!cat.getSatiety()) {
                do {
                    plate.increaseFood();
                    System.out.println(plate);
                    cat.eat(plate);
                    System.out.println(cat);
                } while (!cat.getSatiety());
            }
        }
        System.out.println(plate);
    }
}
