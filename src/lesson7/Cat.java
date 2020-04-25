package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fedUp;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fedUp = false;
    }

    public void eat(Plate plate){
        plate.decreaseFood(appetite);
        fedUp = true;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name = '" + name + '\'' +
                ", appetite = " + appetite +
                ", fedUp = " + fedUp +
                '}';
    }
}
