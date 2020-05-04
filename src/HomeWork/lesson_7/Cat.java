package HomeWork.lesson_7;

public class Cat {
    private String name;
    private boolean fullness;

    private int appetite;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }
    public void eat(Plate p) {
        int foodBefore = p.getFood();
        if(foodBefore < appetite){
            System.out.print(this + ": В тарелке слишком мало еды! Моя порция: " + appetite + " гр. ");
        } else {
            p.decreaseFood(appetite);
            fullness = true;
            System.out.print(this + ": Я cкушал свою порцию: " + appetite + " гр. ");

        }
    }
    public void isFull(){
        if (fullness) {
            System.out.println("Я сыт.");
        } else{
            System.out.println("Хочу жрать!");
        }

    }

    @Override
    public String toString() {
        return name;

    }
}
