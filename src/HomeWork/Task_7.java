package HomeWork;

import java.util.Arrays;

public class Task_7 {
    public static void main (String [] args){
        int a[]= {1, 2, -3, 4, 5, 6};
        move(a,2);
        System.out.println(Arrays.toString(a));

    }

    public static void move(int[] array, int positions) {
        int size = array.length;
        for (int i = size; i > positions; i--) {
            int temp = array[size-1];
            for (int j = size-1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
    }
}
