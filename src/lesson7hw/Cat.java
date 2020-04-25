package lesson7hw;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            this.satiety = true;
        } else System.out.println("В тарелке недостаточно еды для того, чтобы накормить " + name);
    }

    public void getSatiety() {
        System.out.println("Сытость " + name + ": " + satiety);
    }

    public void info() {
        System.out.println("Имя: " + name + " Аппетит: " + appetite + " Сытость: " + satiety);
    }
}
