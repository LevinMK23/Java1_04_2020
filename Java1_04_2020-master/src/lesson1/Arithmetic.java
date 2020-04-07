package lesson1;

public class Arithmetic {
    public static void main(String[] args) {
//        long a = 3;
//        int b = 4;
//        char ch = 'a';
//        ch++;
//        System.out.println(ch);
//        int chi = ch;
//        chi++; //increment
//        char nV = (char) chi;
        // +, -, *, /, %, >>, <<
        // ++ -- += -= *= /=
        int a = 1;
        a++;
        System.out.println(a);
        a--; //a = a - 1
        System.out.println(a);
        a += 7; // a = a + 7
        System.out.println(a);
        a *= 3; // a = a * 3
        System.out.println(a);
        a /= 6; // a = a / 6
        System.out.println(a);
        //++a; a++;
        //--a; a--;
        System.out.println(++a);
        System.out.println(a);
        //a = 5
        a = a++ + ++a; // a - ?
        //a = 5 + 7
        //       6
        //a = 12
        a = a-- - --a; // a = 2
        //   12 -(11) 10 = 12 - 10
        System.out.println(a);
        a++;
        System.out.println(a);
    }
}
