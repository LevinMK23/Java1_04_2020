package HW_Lesson6;

public class Dog extends Animal {
    private static int countDog;
    private int runLimit;
    private int swimLimit;
    private double jumpLimit;

    public Dog(String name) {
        super(name);
        runLimit = 500;
        swimLimit = 10;
        jumpLimit = 0.5;
        countDog++;
    }

    @Override
    public void run(int barrierLenght) {
        super.run(barrierLenght);
        if (runLimit >= barrierLenght)
            System.out.println(this.getName() + " пробежал " + barrierLenght + " м.");
        if (runLimit < barrierLenght)
            System.out.println(this.getName() + ": А давай вместе столько пробежим?!");
    }

    public void jump(double barrierHeight) {
        super.barrierHeight = barrierHeight;
        if (jumpLimit >= barrierHeight)
            System.out.println(this.getName() + " прыгнул на " + barrierHeight + " м.");
        if (jumpLimit < barrierHeight)
            System.out.println(this.getName() + ": Я же не кот!");
    }

    public void swim(int barrierLenght) {
        this.barrierLenght = barrierLenght;
        if (swimLimit >= barrierLenght)
            System.out.println(this.getName() + " проплыл " + barrierLenght + " м.");
        if (swimLimit < barrierLenght)
            System.out.println(this.getName() + ": Ты хочешь чтобы я утонул?");
    }

    public void printCountDog() {
        System.out.printf("собак - %d.", countDog);

    }

}