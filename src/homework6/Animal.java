package homework6;

public abstract class Animal implements Voice, Run, Jump, Swim {
    protected String name;
    protected Color color;
    protected int age;

    protected int runDistanceLimit;
    protected int jumpDistanceLimit;
    protected int swimDistanceLimit;

    public Animal(String name, Color color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRunDistanceLimit() {
        return runDistanceLimit;
    }

    public void setRunDistanceLimit(int runDistanceLimit) {
        this.runDistanceLimit = runDistanceLimit;
    }

    public int getJumpDistanceLimit() {
        return jumpDistanceLimit;
    }

    public void setJumpDistanceLimit(int jumpDistanceLimit) {
        this.jumpDistanceLimit = jumpDistanceLimit;
    }

    public int getSwimDistanceLimit() {
        return swimDistanceLimit;
    }

    public void setSwimDistanceLimit(int swimDistanceLimit) {
        this.swimDistanceLimit = swimDistanceLimit;
    }
}
