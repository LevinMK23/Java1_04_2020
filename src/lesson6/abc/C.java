package lesson6.abc;

public class C extends B {

    private String cData;

    public C(int intField, int packIntField, int protectedIntField, int publicIntField, float bData) {
        super(intField, packIntField, protectedIntField, publicIntField, bData);
    }

    public C(int intField, int packIntField, int protectedIntField, int publicIntField, float bData, String cData) {
        this(intField, packIntField, protectedIntField, publicIntField, bData);
        this.cData = cData;
    }

    @Override
    public void f(int a, int b) {
        System.out.println("a - b = " + (a - b));
    }

    @Override
    public void printClassInfo() {
        printValues();
    }

    @Override
    protected void printValues() {
        super.printValues();
        System.out.println("C values: {" + cData + "}");
    }

    public String getcData() {
        return cData;
    }
}
