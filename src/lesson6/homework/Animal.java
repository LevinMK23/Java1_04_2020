package lesson6.homework;

public abstract class Animal implements InterfaceForAnimals {

    private double distRun, distJump, distSwim;

    public Animal(double distRun, double distJump, double distSwim) {
        this.distRun = distRun;
        this.distJump = distJump;
        this.distSwim = distSwim;
    }

    @Override
    public boolean run(double value) { return distRun > value; }

    @Override
    public boolean jump(double value) { return distJump > value; }

    @Override
    public boolean swim(double value) { return distSwim > value; }

    double getDistRun() { return distRun; }

    double getDistJump() { return distJump; }

    double getDistSwim() { return distSwim; }
}