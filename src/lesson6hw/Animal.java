package lesson6hw;

public class Animal {
    String name;
    private int runLimit;
    private int swimLimit;
    static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
    public Animal () {
        animalCount++;
    }

    void setRunLimit (int runLimit) {
        this.runLimit = runLimit;
    }
    void setSwimLimit (int swimLimit) {
        this.swimLimit = swimLimit;
    }
    void count() {
        System.out.println("Total animals count: " + animalCount);
    }
    void run (int runDist) {
        if ( runDist <= runLimit) {
            System.out.println( name + " пробежал " + runDist + " метров");
        }
        else System.out.println(name + " не может пробежать больше " + runLimit + " метров");
    }

    void swim (int swimDist) {
        if ( swimLimit == 0 ) System.out.println(name + " не может плавать");
        else if ( swimDist <= swimLimit ) System.out.println(name + " проплыл " + swimDist + " метров");
        else System.out.println(name + " не может проплытать больше " + swimLimit + " метров");
    }
}
