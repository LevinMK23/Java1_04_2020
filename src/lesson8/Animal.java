package lesson8;

public class Animal extends MainFrame {

    public String name;
    public int health;
    public int fun;
    public int sleep;
    public int poop;
    public int starv;
    public boolean newGame;

    public Animal(String name, int fun, int sleep, int starv, int poop) {
        this.name = name;
        this.fun = fun;
        this.sleep = sleep;
        this.starv = starv;
        this.poop = poop;
        health = ((this.fun + this.starv - this.sleep - this.poop) / 2);
    }

    // Getters for values
    public String getName() {
        System.out.println(name);
        return null;
    }

    public int getHealth() {
        return health;
    }

    public int getFun() {
        return fun;
    }

    public int getSleep() {
        return sleep;
    }

    public int getStarv() {
        return starv;
    }

    public int getPoop() {
        return poop;
    }

    // Проверка на конец игры
    public boolean healthCheck() {
        if (getHealth() > 0) {
            return true;
        } else return false;
    }


    // Setters for values
    // Chaning stats when pressing a button
    public float setHealth() {
        health = ((this.fun + this.starv - this.sleep - this.poop) / 2);
        System.out.println("Здоровье: " + getHealth());
        return health;
    }

    public void setFun(int play) {
        if (getFun() == 100 || getFun() > 100) {
            System.out.println("Я не хочу играть!!! Отстань!");
        } else {
            this.fun = getFun() + play;
            System.out.println("Хорошо поиграли!");
        }
        setHealth();
    }

    public void setSleep(int snooze) {
        if (getSleep() == 0) {
            System.out.println("Я не хочу спать");
        } else if (getSleep() - snooze < 0) {
            System.out.println("Я не хочу спать");
        } else {
            this.sleep = getSleep() - snooze;
            System.out.println("Я выспался :>");
        }
        setHealth();
    }

    public void setStarv(int food) {
        if (getStarv() == 100) {
            System.out.println("Спасибо, я не голодный");
        } else if (food + getStarv() > 100) {
            System.out.println("Спасибо, я не голодный");
        } else {
            this.starv = getStarv() + food;
            System.out.println("Меня накормили");
        }
        setHealth();
    }

    public void setPoop(int shit) {
        if (getPoop() == 0) {
            System.out.println("Я не хочу в туалет");
        } else if (getPoop() - shit < 0) {
            System.out.println("Я не хочу в туалет");
        } else {
            this.poop = getPoop() - shit;
            System.out.println("С облегчением меня :>");
        }
        setHealth();
    }

    public void updateAnimalStats(int changeValue) {
        this.fun = getFun() - changeValue;
        this.starv = getStarv() - changeValue;
        this.sleep = getSleep() + changeValue;
        this.poop = getPoop() + changeValue;
        setHealth();
    }
}
