package HomeWork.lesson_6;

import java.util.Random;

public class Animal {

    private String type;
    private int swimLimit;
    private int runLimit;
    //private Random random = new Random();

    protected void setType(String type) {
        this.type = type;
    }
    protected String getType(){return type;}
    protected void setSwimLimit(int swimLimit){this.swimLimit = swimLimit;}
    protected void setRunLimit(int runLimit){this.runLimit = runLimit;}

    public void run(int runLength) {
        if (runLength > runLimit) {
            System.out.println(" пробежал " + runLimit + " метров и устал.");
        } else {
            System.out.println(" пробежал " + runLength + " метров!");
        }
    };
    public void swim(int swimLength){
        if (swimLength > swimLimit) {
            System.out.println(" проплыл " + swimLimit + " метров и устал.");
        } else {
            System.out.println(" проплыл " + swimLength + " метров!");
        }
    };


}
