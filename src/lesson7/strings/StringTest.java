package lesson7.strings;

public class StringTest {

    static void stringTest() {
        String s = "a";
        for (int i = 0; i < 100000; i++) {
            s += "a";
        }
    }

    static void stringBuilderTest() {
        StringBuilder s = new StringBuilder("a");
        for (int i = 0; i < 100000; i++) {
            s.append("a");
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        stringTest();
        long endTime = System.currentTimeMillis();
        System.out.println("Test String, time: " + (endTime - startTime) + "ms.");
        startTime = System.currentTimeMillis();
        stringBuilderTest();
        endTime = System.currentTimeMillis();
        System.out.println("Test StringBuilder, time: " + (endTime - startTime) + "ms.");
    }
}
