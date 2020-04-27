package lesson7.homework;

public class FoodTest {
    public static void main(String[] args) {
        System.out.println("All cats:");
        Cat[] cats = {
            new Cat("Robin", 15),
            new Cat("Kirpich", 20),
            new Cat("Molot", 10),
            new Cat("Nerv", 15)
        };
        Plate plate = new Plate(100);

        for (Cat kitty : cats) { System.out.println(kitty); }

        System.out.println("\n" + plate);
        System.out.println("");
        System.out.println("add more food by 100");

        plate.addMoreFood(100);

        System.out.println(plate);
        System.out.println("");
        System.out.println("Cats take food:");

        for (Cat kitty : cats) {
            kitty.eat(plate);
            System.out.println(kitty);
            System.out.println(plate);
        }
    }
}
