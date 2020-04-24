public class Animal {

    private String type, name;
    private static int counter=0;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
        counter++;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static int getCounter() { return counter; }


    public void run(int distance) {
        System.out.println(getType() + " " + getName() + " пробежал " + distance + " mетров");
    }

    public void swim(int distance) {
        System.out.println(getType() + " " + getName() + " проплыл " + distance + " метров");
    }
}

