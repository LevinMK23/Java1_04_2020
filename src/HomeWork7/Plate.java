package HomeWork7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {

        if (food >= n){
            food -= n;
            return true;
        }
        else{
            System.out.println("Еды недостаточно");
            return false;
        }

    }

    public void addFood(int n){
        food += n;
    }


    public void info() {
        System.out.println("plate: " + food);
    }
}
