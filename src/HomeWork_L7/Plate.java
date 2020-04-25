package HomeWork_L7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (food>=n) {
            food -= n;
            System.out.println("I'm full");
        } else System.out.println("Hey! Where is my food man! I need more food " + n);
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int d){
        food += d;
    }

}
