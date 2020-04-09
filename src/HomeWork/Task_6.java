package HomeWork;

public class Task_6 {
    public static void main(String[] args) {
        int[] checkBalance = {2, 2, 2, 1, 2, 2, 2,1};
        int sum1 = 0 , sum2 = 0;
        for (int i = 0; i <4 ; i++) {
            sum1+=checkBalance[i];
        }
        for (int i = 4; i < checkBalance.length; i++) {
            sum2+=checkBalance[i];
        }
        if (sum1==sum2) System.out.println("True");

    }
}
