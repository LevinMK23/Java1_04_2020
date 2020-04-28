package lesson7.HW;

public class Cat {
    private String name;
    private int food;
    private boolean fullness;

    Cat(String name, int food) {
        this.name = name;
        this.food = food;
        this.fullness = false;
    }

    @Override
    public String toString() {
        return "Кот: " + name + " " +
                "хочет съесть " + food + "г. " +
                "Наелся? " + fullness;
    }

    void eat(Plate plate) {
        if (plate.getFood() > food) {
            plate.removeFood(food);
            fullness = true;
        } else {
            System.out.println(name + " хочет кушать. Не хватило еды.");
        }
    }
}