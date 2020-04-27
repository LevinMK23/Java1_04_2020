package lesson7;

import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        SingletonTest test = SingletonTest.getInstance();
        test.test();
        // Executors.newFixedThreadPool();
    }
}
