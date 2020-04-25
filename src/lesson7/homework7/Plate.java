package lesson7.homework7;

import sun.awt.geom.AreaOp;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void add(int food) {
        this.food += food;
    }

    public boolean decreaseFood(int n) {
        int nyam = food - n;
        if(nyam < 0 ) return false;

        food -= n;
        return true;

    }

    public void info() {
        System.out.println("plate:" + food);
    }
}
