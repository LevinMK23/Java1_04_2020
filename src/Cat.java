public class Cat extends Animal {

    public Cat(String type, String name) { super(type, name); }

    @Override
    public void run(int distance) {
        int runLimit = 200;
        if (runLimit <= distance) System.out.println(getType() + " " + getName() + ": это, конечно, хорошо, но делать этого - я не буду.");
        else super.run(distance);
    }

    @Override
    public void swim(int distance) { System.out.println(getType() + " " + getName() + ": плавай сам"); }
}
