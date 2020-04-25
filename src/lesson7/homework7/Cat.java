package lesson7.homework7;

import sun.font.DelegatingShape;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = true;

    }

    public void eat(Plate p, int food) {
        p.decreaseFood(appetite);
        if(appetite > food) {
            System.out.println(name + " не сьел" );
            full = false;
        }else {
            System.out.println(name + " сьел: " + appetite);
            full = true;
        }
//        if(full && p.decreaseFood(appetite))
//            full = false;
    }

}
