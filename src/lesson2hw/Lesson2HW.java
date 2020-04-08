package lesson2hw;

import java.util.Arrays;

public class Lesson2HW {

    static void task1 () {
        int[] task1Array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < task1Array.length ; i++) {
            if ( task1Array[i] == 0 ) {
                task1Array[i] = 1;
            } else if ( task1Array[i] == 1 ) {
                task1Array[i] = 0;
            }
        }
        System.out.println("Task 1: " + Arrays.toString(task1Array));
    }

    static void task2 () {
        int[] task2Array = new int[8];
        for (int i = 0; i < task2Array.length; i++) {
            task2Array[i] = i * 3;
        }
        System.out.println("Task 2: " + Arrays.toString(task2Array));
    }

    static void task3 () {
        int[] task3Array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < task3Array.length; i++) {
            if ( task3Array[i] < 6) {
                task3Array[i]*=6;
            }
        }
        System.out.println("Task 3: " + Arrays.toString(task3Array));
    }

    static void task4 () {
        int[][] task4Array = new int[8][8];
        for (int i = 0; i < task4Array.length; i++) {
            for (int j = 0; j < task4Array[i].length; j++) {
                if (i == j) {
                    task4Array[i][j] = 1;
                }
            }
        }
        System.out.println("Task 4: ");
        for (int i = 0; i < task4Array.length; i++) {
            System.out.println(Arrays.toString(task4Array[i]));
        }
    }

    static void task5 (int [] array) {
        int max = array[0], min = array[0];
        for (int i = 0; i < array.length; i++) {
            if ( array[i] > max ) {
                max = array[i];
            } else if ( array[i] < min ) {
                min = array[i];
            }
        }
        System.out.println("Task 5: Max element: " + max + " Min element: " + min);
    }

    static boolean task6 (int [] array) {
        for (int i = 0; i < array.length + 1 ; i++) {
            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < i; j++) leftSum += array[j];

            for (int j = i; j < array.length; j++) rightSum += array[j];

            if (leftSum == rightSum) return true;
        }
        return false;
    }

    static void task7 (int[] array, int shift) {
        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                int endElement = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = endElement;
            }
        } else if (shift < 0) {
            for (int i = 0; i < shift * (-1); i++) {
                int tmp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = tmp;
            }
        }
        System.out.println("Task 7: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        int[] task5Array = {6, 30, 18, 12, 11, 24, 30, 12, 24, 8, 9, 6};
        task5(task5Array);
        int[] task6Array = {1, 1, 1, 5, 2, 1};
        System.out.println("Task 6: " + task6(task6Array));
        int[] task7Array = {1, 1, 1, 5, 2, 1, 0, 0, 5, 6};
        task7(task7Array, -3);

    }
}
