package lesson6.abc;

import java.util.Arrays;

public class B extends A {

    private float bData;

//    public B (int a, int b, int c, int d, int e) {
//        super(a,b,c,d);
//        this.bData = e;
//    }
//
//    public B (int a, int b, int c, int d, int e, int f) {
//        this(a,b,c,d,e);
//        this.bData = f;
//    }


    public float getbData() {
        return bData;
    }

    public B(int intField, int packIntField, int protectedIntField, int publicIntField, float bData) {
        super(intField, packIntField, protectedIntField, publicIntField);
        this.bData = bData;
    }


    public void printClassInfo() {
        System.out.println("Class B");
        // %d int, %f double %c char %s String
        printValues();
    }

    @Override
    protected void printValues() {
        super.printValues();
        System.out.println("B values: {" + bData + "}");
    }

    // overloading
    public void f(int a, int b) {
        System.out.println("a + b = " + (a + b));
    }

    public void f(float a, float b) {
        System.out.println("a / b = " + (a / b));
    }

    public void f(int... params) {
        int sum = 0;
        for(int i : params) sum += i;
        System.out.println("params = " + Arrays.toString(params) + "\nsum = " + sum);
    }

}
