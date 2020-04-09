package HomeWork;

import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {
//        int[] a = {10,30,59,45,85,69,18,365,1};
        int[] a = new int[10];
        int c;
        for (int i = 0; i <a.length ; i++) {
            c = 1 + (int) (Math.random() * 60);
            a[i] = c;
        }

        int min, max;
        min = max = a[0];
        for (int i = 0; i <a.length ; i++) {
            if (a[i]<min) min=a[i];
            if (a[i]>max) max=a[i];

        }
        System.out.println(max);
        System.out.println(min);

        System.out.println(Arrays.toString(a));
    }
}
