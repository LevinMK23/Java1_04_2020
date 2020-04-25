public class Cat {
    private String name;
    private int appetite;
    private boolean catFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String isCatFull(){
        catFull = true;
        return "Cat " +name+ " has been fed: " + catFull;
    }

    public void eat(Plate plate) {
        if (appetite <= plate.getFood()) {
            plate.descreaseFood(appetite);
            System.out.println(isCatFull());
        } else {
            plate.addFood(appetite);
            plate.descreaseFood(appetite);
            System.out.println(isCatFull());
        }
    }
}

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void plateInfo(){
        System.out.println("Amount of food left: " + food);
    }

    public void descreaseFood(int n){
        food -= n;
    }

    public void addFood(int n){
        food += n;
    }

    public int getFood(){
        return food;
    }
}

public class Test {

    public static void main(String[] args) {
        Cat[] catArray = new Cat[3];
        catArray[0]  = new Cat("Barsik",30);
        catArray[1]  = new Cat("Murzik",40);
        catArray[2]  = new Cat("Snezhok",10);
        Plate plate =  new Plate(70);

        for (int i = 0; i < catArray.length; i++) {
            catArray[i].eat(plate);
        }
        plate.plateInfo();
    }
}





