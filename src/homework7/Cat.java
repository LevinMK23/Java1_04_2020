package homework7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFed = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFed() {
        return isFed;
    }

    public void eatFrom(Plate plate) {
        try {
            plate.decFood(this.appetite);
            this.isFed = true;
            System.out.println(String.format("%s is fully fed", this.name));
        } catch (RuntimeException e) {
            System.out.println(String.format("There is not enough food in plate. %s is still hungry", this.name));
        }
    }

    @Override
    public String toString() {
        String str = String.format("Name: %s\n" +
                "Appetite: %d\n" +
                "Is fed: %b", this.name, this.appetite, this.isFed);
        return str;
    }
}
