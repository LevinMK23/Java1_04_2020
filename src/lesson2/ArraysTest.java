package lesson2;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysTest {

    static void arrayMethod(int[] array) {
        if (array.length > 4) {
            array[3] = 5;
        }
    }

    static int[] method(int[] a) {
        int[] tmp = a.clone();
        for (int i = 0; i < tmp.length; i++) {
            tmp[i]++;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        System.out.println(Arrays.toString(a));
        a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        //for each
        //a :      1 2 3 4 5 6 7 8 9 10
        //                           value
        for (int value : a) {
            System.out.print(value + " ");
        }
        // Stream API google help
        // Stream.of(a).forEach(System.out::print);
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = i * j;
            }
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
//        Это неровный массив
//        int[][] d = new int[5][];
//
//        for (int i = 0; i < d.length; i++) {
//            d[i] = new int[1 + (int) (Math.random() * 15)]; // random 1 ... 14
//        }
//
//        for (int i = 0; i < d.length; i++) {
//            for (int j = 0; j < d[i].length; j++) {
//                System.out.print(d[i][j] + " ");
//            }
//            System.out.println();
//        }
        int[] array = new int[5]; // 0 0 0 0 0
        arrayMethod(array); // 0 0 0 5 0
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(method(array)));
        // 1 1 1 6 1
    }
}
