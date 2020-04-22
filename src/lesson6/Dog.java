package lesson6;

public class Dog extends Animal {
    private static int countDog;
    private int runLimit;
    private int swimLimit;

    public Dog(String name) {
        super(name);
        runLimit = 500;
        swimLimit = 10;
        countDog++;
    }

    @Override
    public void run(int barrierLenght) {
        super.run(barrierLenght);
        if (runLimit >= barrierLenght)
            System.out.println(this.getName() + " пробежал " + barrierLenght + " м.");
        if (runLimit < barrierLenght)
            System.out.println("Не издевайся.");
    }

    public void swim(int barrierLenght) {
        this.barrierLenght = barrierLenght;
        if (swimLimit >= barrierLenght)
            System.out.println(this.getName() + " проплыл " + barrierLenght + " м.");
        if (swimLimit < barrierLenght)
            System.out.println("Лучше кота попроси.");
    }

    public void printCountDog() {
        System.out.printf("собак - %d.", countDog);

    }

}
