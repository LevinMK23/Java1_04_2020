package LessonOOP;

public class Cat {
    private String name;
    private int appetite;

    public String getName() {
        return name;
    }

    private boolean hungry = false;

    public void Hungry(boolean hungry){
        this.hungry = hungry;
    }

    public boolean isHungry() {
        return hungry;
    }

    public int getAppetite() {
        return appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite);
        if(p.getFood() >= 0)Hungry(true);
        else Hungry(false);
    }

}
