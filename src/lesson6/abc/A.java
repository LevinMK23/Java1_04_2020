package lesson6.abc;

public class A {

    private int intField;
    int packIntField; // package private
    protected int protectedIntField;
    public int publicIntField;


    public A(int intField, int packIntField, int protectedIntField, int publicIntField) {
        this.intField = intField;
        this.packIntField = packIntField;
        this.protectedIntField = protectedIntField;
        this.publicIntField = publicIntField;
    }

    public void printClassInfo() {
        System.out.println("Class A");
        // %d int, %f double %c char %s String
        printValues();
    }

    protected void printValues() {
        String values = String.format("{%d, %d, %d, %d}",
                intField, packIntField, protectedIntField, publicIntField);
        System.out.println("A values: " + values);
    }
}
