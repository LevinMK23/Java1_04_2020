package lesson7.strings;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("aaaa");
        str.setCharAt(2, 'z');
        System.out.println(str);
        str.insert(1, "15").insert(4, "OZ")
        .insert(7, "OIL").insert(10, "Java");
        System.out.println(str);
        System.out.println(str.delete(3, 6));

    }
}
