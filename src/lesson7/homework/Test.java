package lesson7.homework;

public class Test {
    public static void main(String[] args) {
        System.out.println("All cats:");
        Cat[] cats = {
                new Cat("Barak", 20),
                new Cat("Rij", 35),
                new Cat("Bui", 12),
                new Cat("Bolt", 10)
        };
        Plate plate = new Plate(100);

        for (Cat kitty : cats) { System.out.println(kitty); }

        System.out.println("\n" + plate);
        System.out.println("");
        System.out.println("add more food by 200");

        plate.addMoreFood(200);

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
