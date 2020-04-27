package lesson7;

public class FabricTest {

    public static A getA() {
        return new A();
    }

    public static B getB() {
        return new B();
    }

    public static C getC() {
        return new C();
    }

    private static class A {
        public void foo() {
            System.out.println("A");
        }
    }

    private static class B {
        public void foo() {
            System.out.println("B");
        }
    }

    private static class C {
        public void foo() {
            System.out.println("C");
        }
    }

}
