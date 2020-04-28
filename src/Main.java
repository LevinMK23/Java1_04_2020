public class Main {
    public static void main(String[] args) {
        Cat[] cat = new Cat[5];
        Plate plate = new Plate(15);
        plate.info();
        for (int i = 0; i < cat.length; i++) {
            cat[i] = new Cat("Barsik" + i, 5 - i );
            cat[i].eat(plate);
        }
        plate.setFood(1000);
        plate.info();
    }
}
