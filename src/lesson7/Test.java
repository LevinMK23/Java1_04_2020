package lesson7;

public class Test {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Murzik", 70),
                new Cat("Fedya", 45),
                new Cat("Bonny", 38),
                new Cat("Barsik", 110),
        };

        Plate plate = new Plate(250);
        for (Cat eachCat: cats) {
            eachCat.eat(plate);
            System.out.println(eachCat.toString());
        }

    }
}

