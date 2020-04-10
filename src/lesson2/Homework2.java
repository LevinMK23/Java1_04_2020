package lesson2;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Homework2 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        int[] a = {10,-3,7};
        System.out.println(task6(a));
        int[] b = {1,2,3,4,5,6,7,8,9};
        task7(b,4);
        int[] c = {1,2,3,4,5,6,7,8,9};
        task7(c,-4);
    }

    public static void task1(){
        System.out.println("task1");
        int[] a = {1,1,0,0,1,0,1,1,0,0};
        for (int i = 0; i < a.length; i++) {
            a[i] = (a[i]==0)?1:0;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void task2(){
        System.out.println("task2");
        int a[] =  new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = i*3;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void task3(){
        System.out.println("task3");
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < a.length; i++) {
            a[i] *= (a[i]<6)?2:1;
        }
        System.out.println(Arrays.toString(a));
    }
    public static void task4(){
        System.out.println("task4");
        int[][] a = new int[3][3];
        for (int i = 0; i < a[0].length; i++) {
            a[i][i] = 1;
            System.out.println(Arrays.toString(a[i]));
        }
       // System.out.println(Arrays.toString(a));
    }
    public static void task5(){
        System.out.println("task5");
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int min,max;
        min = max = a[0];
        for (int i = 0; i < a.length; i++) {
            min = (min>a[i])?a[i]:min;
            max = (max<a[i])?a[i]:max;

        }
        System.out.println(Arrays.toString(a));
        System.out.printf("min = %d, max = %d\n",min,max);
    }

    public static boolean task6(int[] a) {
        System.out.println("task6");
        if (a.length < 2) return false;
        int sumLeft = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            sumLeft += a[i];
        }
        int sumRight = a[a.length - 1];

        for (int i = a.length - 2; (i > 1) && (sumRight != sumLeft); i--) {
            sumLeft -= a[i];
            sumRight += a[i];
        }

        return (sumRight == sumLeft);
    }

    public static void task7(int[] a, int n){
        System.out.println("task7");
        if ((n>=a.length) || (n+a.length<=0)){
            System.out.println(Arrays.toString(new int[a.length]));
            return;
        }else  if (n == 0){
            System.out.println(Arrays.toString(a));
            return;
        }

        if (n<0) {
            for (int i = 0; i < a.length + n; i++) {
                a[i] = a[i-n];
                a[i-n] = 0;
            }
        }else{
            for (int i = a.length-1; i >= n; i--) {
                a[i] = a[i-n];
                a[i-n] = 0;
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
