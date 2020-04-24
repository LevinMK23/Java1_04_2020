package HW_Lesson6;

public class Cat extends Animal {
    private static int countCat;
    private int runLimit;
    private int jumpLimit;
    private int swimLimit;

    public Cat(String name) {
        super(name);
        runLimit = 200;
        jumpLimit = 2;
        swimLimit = 0;
        countCat++;
    }

    @Override
    public void run(int barrierLenght) {
        super.run(barrierLenght);
        if (runLimit >= barrierLenght)
            System.out.println(this.getName() + " пробежал " + barrierLenght + " м.");
        if (runLimit < barrierLenght)
            System.out.println(this.getName() + ": Слишком далеко!");
    }

    public void swim(int barrierLenght) {
        this.barrierLenght = barrierLenght;
        if (swimLimit >= barrierLenght)
            System.out.println(this.getName() + " проплыл " + barrierLenght + " м.");
        if (swimLimit < barrierLenght)
            System.out.println(this.getName() + ": Я же кот, никуда я не поплыву");
    }

    public void jump(int barrierHeight) {
        super.barrierHeight = barrierHeight;
        if (jumpLimit >= barrierHeight)
            System.out.println(this.getName() + " прыгнул на " + barrierHeight + " м.");
        if (jumpLimit < barrierHeight)
            System.out.println(this.getName() + ": Слишком высоко!");
    }



    public void printCountCat() {
        System.out.printf("Из них котов - %d, ", countCat);
    }

}