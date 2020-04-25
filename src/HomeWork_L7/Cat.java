package HomeWork_L7;

public class Cat {

    private String name;
    private int appetite;
    private static int satiety = 0;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = appetite;
    }
    public void eat(Plate p) {
      p.decreaseFood(appetite);

    }


}
