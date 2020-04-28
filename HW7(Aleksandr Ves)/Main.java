package geekbrains.lession0;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 5, false);
        Cat cat2 = new Cat("Barsik", 6, false);
        Cat cat3 = new Cat("Barsik", 8, false);
        Cat cat4 = new Cat("Barsik", 2, false);
        Cat cat5 = new Cat("Barsik", 4, false);
        Plate a = new Plate(15);
        a.info();
        cat1.eat(a);
        cat1.infosatiety();
        a.info();
        cat2.eat(a);
        cat2.infosatiety();
        a.info();
        cat3.eat(a);
        cat3.infosatiety();
        a.info();
        a.addFood(5);
        a.info();
        cat4.eat(a);
        cat4.infosatiety();
        a.info();
        cat5.eat(a);
        cat5.infosatiety();

    }
}