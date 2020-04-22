package lesson6;

public class Cat extends Animal {
    private static int countCat;
    private int runLimit;

    public Cat(String name) {
        super(name);
        runLimit = 200;
        countCat++;
    }

    @Override
    public void run(int barrierLenght) {
        super.run(barrierLenght);
        if (runLimit >= barrierLenght)
            System.out.println(this.getName() + " пробежал " + barrierLenght + " м.");
        if (runLimit < barrierLenght)
            System.out.println("Сам беги так много!");
    }

    public void printCountCat() {
        System.out.printf("Из них котов - %d, ", countCat);
    }

}
