package lesson7;

import static lesson7.Plate.starv;

public class Cat {

    String name;
    private int appetite;


    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p){
        p.decreaseFood(appetite);
        if (starv == true) {
        System.out.println("Кот " + getName() + " поел");
        appetite = 0;
        } else {
            System.out.println("Кот " + getName() + " не поел");
        }

    }

    public String getName() {
        return name;
    }

    public int getAppetite(){
        return appetite;
    }
}
