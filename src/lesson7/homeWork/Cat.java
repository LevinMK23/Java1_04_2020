package lesson7.homeWork;

 public class Cat {
    private String name;
    private int weight;
    private int needToBeSatiety;
    private int satiety = 0;
    private boolean isHunger;

     public boolean isHunger(int satiety) {
         if (satiety == needToBeSatiety){
             isHunger = true;
         }
         return isHunger;
     }

     public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
        needToBeSatiety = weight * 40;

    }

    public int getNeedToBeSatiety() {
        return needToBeSatiety;
    }
    public void eat(Plate p){
        if (!isHunger){
            if (p.getFood() > needToBeSatiety){
                satiety = needToBeSatiety;
                isHunger(satiety);
                int x = p.getFood() - satiety;
                p.setFood(x);
                System.out.println();
            } else {
                System.out.printf("\n %s слишком мало того, что осталось в тарелке...", name);
            }
        } else {
            System.out.printf("\n %s не голоден, он пошел спать", name);
        }
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", needToBeSatiety=" + needToBeSatiety +
                ", satiety=" + satiety +
                ", isHunger=" + isHunger +
                '}';
    }
}
