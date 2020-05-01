package lesson7.homework;

public class Cat {
    private String name;
    private int satisfaction;
    private boolean fullness;

    Cat(String name, int satisfaction) {
        this.name = name;
        this.satisfaction = satisfaction;
        this.fullness = false;
    }

    @Override
    public String toString() {
        return "Cat: " + name + " > " +
                "Satisfaction: " + satisfaction + " > " +
                "Fullness: " + fullness;
    }

    void eat(Plate plate) {
        if (plate.getFood() > satisfaction) {
            plate.removeFood(satisfaction);
            fullness = true;
        } else {
            System.out.println("Cat " + name + " wants more food");
        }
    }
}
