package lesson1;

public class DataTypes {

    public static void main(String[] args) {
        // DataTypes dt = new DataTypes(); // linked type
        // int a = 3; // primitive
        // byte, short, int, long, float, double, char, boolean, (void)
        byte byteValue = 3; // 8 bit [-2 ** 7; 2 ** 7) [-128; 127]
        short shortValue = 32000; // 16 bit [-2 ** 15; 2 ** 15)
        int intValue = 2; // 32 bit 10 ** 9
        long longValue = 1111111111111111L; // 64 bit 10 ** 19
        int a = 7;
        float b = 2.2f; // 32 bit 8 знаков
        double doubleValue = 15.3557; // 64 bit 16 знаков
        double x = 1, y = 3;
        System.out.println(x / y);
        // int, double;
        char sym = 'a';
        System.out.println((char)(sym + 1));
        String s = "aassfjfjfj";
        boolean flag = true; // false нельзя 0 1
    }
}
