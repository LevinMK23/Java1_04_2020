package lesson7.HomeWork;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }


    public String getName() {
        return name;
    }



    public void eat (Plate plate){
        if (plate.isEnoughFood(this )) {
            plate.decreaseFood(appetite);
            satiety = true;
        }else System.out.println("There is not enough food for " + getName());
    }

    public void satietyInfo(){
        if (satiety) {
            System.out.println(getName() + " says: I'm full");
        }else System.out.println(getName() + " says: I,m still hungry, add some food in the plate");
    }
}
