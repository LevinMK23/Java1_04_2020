package homework6;

public class Dog extends Animal {

    private static long population;

    public Dog(String name, Color color, int age) {
        super(name, color, age);

        this.jumpDistanceLimit = 10;
        this.runDistanceLimit = 500;
        this.swimDistanceLimit = 50;

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
        if (distance < 0) {
            System.out.println(String.format("%s, does not want to swim", this.getName()));
            return;
        }

        int swimDistance = distance > this.swimDistanceLimit ? this.swimDistanceLimit : distance;

        System.out.println(String.format("%s swam %d meters", this.name, swimDistance));
    }

    @Override
    public void voice() {
        System.out.println(String.format("%s says 'Bark!'", this.name));
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        population--;
    }
}
