package lesson7.homeWork;

public class Plate {
    private int food;

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        if(food < 0){
            this.food = 0;
        }else if (food > 1000){
            System.out.println("Слишком много положил, много вылетело из тарелки, но зато она забита до краев, теперь там 1000 гр. корма");
            this.food = food;
        } else {
            this.food = food;
        }
    }
    public void addFood(int x){
        if(x < 0){
            System.out.println("Зачем ты забираешь еду у котиков? они тебе не дадут этого сделать! в тарелке сколько было, столько и останется еды");
        }else if (food > 1000){
            System.out.println("Слишком много положил, много вылетело из тарелки, но зато она забита до краев, теперь там 1000 гр. корма");
            food = 1000;
        } else {
            food += x;
        }
        System.out.printf("Теперь в тарелке %d гр. еды", food);
    }
}
