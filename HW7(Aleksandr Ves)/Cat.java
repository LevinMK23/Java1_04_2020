package geekbrains.lession0;


public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;


    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void satiety(boolean b) {
        satiety = true;
    }

    public void infosatiety() {
        System.out.println("satiety: " + satiety);
    }


    public void eat(Plate p) {
        boolean x=p.decreaseFood(appetite);
        if (x==true) {
            satiety=true;
        }
    }
}
