package lesson7;

public class Cat {
    private final int appetite;
    private final String name;
    private boolean fed;

    public Cat(int appetite, String name) {
        this.appetite = appetite;
        this.name = name;
        this.fed = false;
    }

    public void eat(Plate p) {
        if (!isFed()) setFed(p.decreaseFood(getAppetite()));
    }

    public boolean isFed() {
        return fed;
    }

    public void setFed(boolean fed) {
        this.fed = fed;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", fed=" + fed +
                '}';
    }
}
