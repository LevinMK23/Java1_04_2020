package HomeWork;

public class task_3 {

    public static void main(String[] args) {
        float a = 12.24f;
        float b = 2.24f;
        float c = 1.2f;
        float d = 5.1f;

        System.out.println(findResult(a,b,c,d));

    }
    private static float findResult(float a, float b, float c, float d){
        return (a * (b + (c / d)));
    }
}
