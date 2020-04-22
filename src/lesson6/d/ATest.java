package lesson6.d;

import lesson6.abc.A;
import lesson6.abc.B;
import lesson6.abc.C;

public class ATest {
    public static void main(String[] args) {
        A a = new A(1, 2, 3, 4);
        a.printClassInfo();
        B b = new B(5,4,3,2,1);
        b.printClassInfo();
        b.f(1, 2, 4, 4, 5, 6, 7, 8, 3, 1, 4);
        C c = new C(1,2,3,4,5, "asdfg");
        c.printClassInfo();
        c.f(5, 7);
        Class object = c.getClass();
        while (object != null) {
            System.out.println(object.getName());
            object = object.getSuperclass();
            if (object == null) {
                System.out.println("null, have not super class");
            }
        }
    }
}
