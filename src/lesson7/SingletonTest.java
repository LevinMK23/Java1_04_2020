package lesson7;

public class SingletonTest {

    public void test() {
        System.out.println("Test passed!");
    }

    private static SingletonTest instance = null;

    public static SingletonTest getInstance() {
        if (instance == null) {
            instance = new SingletonTest();
        }
        return instance;
    }

    private SingletonTest(){

    }
}
