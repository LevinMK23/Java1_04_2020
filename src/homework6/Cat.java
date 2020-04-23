package homework6;

public class Cat extends Animal {

    private static long population;

    public Cat(String name, Color color, int age) {
        super(name, color, age);

        this.jumpDistanceLimit = 5;
        this.runDistanceLimit = 200;

        population++;
    }

    public static long getPopulation() {
        return population;
    }

    @Override
    public void jump(int distance) {
        if (distance < 0) {
            System.out.println(String.format("%s, does not want to jump", this.name));
            return;
        }

        int jumpDistance = distance > this.jumpDistanceLimit ? this.jumpDistanceLimit : distance;

        System.out.println(String.format("%s jumped %d meters", this.name, jumpDistance));
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println(String.format("%s, does not want to run", this.name));
            return;
        }

        int runDistance = distance > this.runDistanceLimit ? this.runDistanceLimit : distance;

        System.out.println(String.format("%s ran %d meters", this.name, runDistance));
    }

    @Override
    public void swim(int distance) {
        System.out.println(String.format("%s can't swim", this.name));
    }

    @Override
    public void voice() {
        System.out.println(String.format("%s says 'Meow!'", this.name));
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        population--;
    }
}
