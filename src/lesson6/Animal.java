package lesson6;

public abstract class Animal {
    private double jumpLimit, swimLimit, runLimit;

    public Animal() {
    }

    public Animal(double jumpLimit, double swimLimit, double runLimit) {
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
        this.runLimit = runLimit;
    }

    public void run(double distance) {
        System.out.println("run: " + (distance < getRunLimit()));
    }

    public void swim(double distance) {
        System.out.println("swim: " + (distance < getSwimLimit()));
    }

    public void jump(double height) {
        System.out.println("jump: " + (height < getJumpLimit()));
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(double jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public double getSwimLimit() {
        return swimLimit;
    }

    public void setSwimLimit(double swimLimit) {
        this.swimLimit = swimLimit;
    }

    public double getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(double runLimit) {
        this.runLimit = runLimit;
    }
}
