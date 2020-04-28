public class Cat {
    private final String name;
    private final int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            System.out.println(this.name + " поел и сыт");
        } else {
            System.out.println(this.name + " не хватило еды, " + this.name + " голодный");
        }
    }
}
